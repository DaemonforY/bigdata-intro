package day02.homework;

import java.time.LocalDate;

public class data_homework
    /*
    使用LocalDate类计算某个日期15天后的日期，并格式化输出。
     */
{
    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(2025, 4, 19);
        LocalDate endDate = startDate.plusDays(15);
        System.out.println(endDate);
    }
}
