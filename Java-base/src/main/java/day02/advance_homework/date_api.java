package advance_homework;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

class date {
    /*
    1. 日期时间API综合应用
   - 作业描述：编写一个日程安排程序，要求包括以下功能：
   - 可输入一个日期并计算到该日期的剩余天数。
   - 输入两个日期，计算它们之间的周数差异。
   - 格式化输出当前日期为YYYY/MM/DD格式。
   - 可根据定义的时间段（如早上、下午、晚上）输出问候语。
   - 要求：使用LocalDate、Period、LocalTime、DateTimeFormatter等API。
     */
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== 日程安排程序 ===");
            System.out.println("1. 计算到指定日期的剩余天数");
            System.out.println("2. 计算两个日期之间的周数差异");
            System.out.println("3. 格式化输出当前日期");
            System.out.println("4. 根据时间段输出问候语");
            System.out.println("5. 退出");
            System.out.print("请选择功能(1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    calculateDaysRemaining();
                    break;
                case 2:
                    calculateWeeksBetween();
                    break;
                case 3:
                    formatCurrentDate();
                    break;
                case 4:
                    timeBasedGreeting();
                    break;
                case 5:
                    System.out.println("感谢使用日程安排程序，再见！");
                    return;
                default:
                    System.out.println("无效选择，请重新输入！");
            }
        }
    }

    // 查询剩余天数
    private static void calculateDaysRemaining() {
        System.out.print("请输入目标日期(格式: yyyy-MM-dd): ");
        String input = scanner.nextLine();

        LocalDate targetDate = LocalDate.parse(input);
        LocalDate today = LocalDate.now();

        long daysRemaining = ChronoUnit.DAYS.between(today, targetDate);

        System.out.printf("从今天(%s)到%s还有%d天\n",
                today.format(DATE_FORMATTER),
                targetDate.format(DATE_FORMATTER),
                daysRemaining);
    }


    // 计算相差周数
    private static void calculateWeeksBetween() {
        System.out.print("请输入第一个日期(格式: yyyy-MM-dd): ");
        LocalDate date1 = LocalDate.parse(scanner.nextLine());

        System.out.print("请输入第二个日期(格式: yyyy-MM-dd): ");
        LocalDate date2 = LocalDate.parse(scanner.nextLine());

        if (date1.isAfter(date2)) {
            LocalDate temp = date1;
            date1 = date2;
            date2 = temp;
        }

        Period period = Period.between(date1, date2);

        System.out.printf("%s 和 %s 之间相差：%d 年 %d 个月 %d 天\n",
                date1.format(DateTimeFormatter.ISO_LOCAL_DATE),
                date2.format(DateTimeFormatter.ISO_LOCAL_DATE),
                period.getYears(),
                period.getMonths(),
                period.getDays());
    }


    // 格式化输出
    private static void formatCurrentDate() {
        LocalDate today = LocalDate.now();
        System.out.println("当前日期(YYYY/MM/DD格式): " + today.format(DATE_FORMATTER));
    }


    // 打招呼
    private static void timeBasedGreeting() {
        LocalTime now = LocalTime.now();
        String greeting;

        if (now.isBefore(LocalTime.NOON)) {
            greeting = "早上好！";
        } else if (now.isBefore(LocalTime.of(18, 0))) {
            greeting = "下午好！";
        } else {
            greeting = "晚上好！";
        }

        System.out.printf("现在是%s，%s\n", now.format(DateTimeFormatter.ofPattern("HH:mm")), greeting);
    }
}