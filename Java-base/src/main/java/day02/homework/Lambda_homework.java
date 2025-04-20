package day02.homework;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda_homework {
    /*
    编写一个程序，使用Lambda表达式过滤列表中的奇数，并对结果进行排序。
     */
    public static void main(String[] args) {
        List<Integer> list =Arrays.asList(2,3,4,1,5,6,12,4);
        List<Integer> list1 = list.stream().
                filter(i -> i % 2 == 0).
                sorted().
                collect(Collectors.toList());
        System.out.println(list1);
    }
}
