package day02;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.concurrent.Callable;

public class Lambda01 {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // 使用 Lambda 表达式遍历列表
        names.forEach(System.out::println);

        System.out.println("----------------------------------------------------------------");

//        printNames(names);

        // 传统的匿名内部类
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!");
            }
        };

        // 使用 Lambda 表达式
        Runnable runnable2 = () -> System.out.println("Hello World!");

        // 使用 Lambda 表达式和 Stream API 进行并行计算
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        OptionalInt max = numbers.parallelStream().mapToInt(Integer::intValue).max();
        System.out.println(max.getAsInt());

        Callable<Integer> integerCallable = () -> 5;

        System.out.println(integerCallable);




        // 类型声明
        MathOperation addition = (int a, int b) -> a + b;

        // 不用类型声明
        MathOperation subtraction = (a, b) -> a - b;

        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> { return a * b; };

        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;

        Lambda01 tester = new Lambda01();
        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        // 不用括号
        GreetingService greetService1 = message ->
                System.out.println("Hello " + message);

        // 用括号
        GreetingService greetService2 = (message) ->
                System.out.println("Hello " + message);

        greetService1.sayMessage("Runoob");
        greetService2.sayMessage("Google");
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }


    public static void printNames(List<String> names) {
        for (String name : names) {
            System.out.println(name);
        }
    }
}
