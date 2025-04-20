package day02.homework;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Stream_homework {
    /*
    使用Stream API从字符串列表中筛选包含指定字符的元素，并将其转换为大写。
     */
    public static void main(String[] args) {

        List<String> words = Arrays.asList("apple", "Banana", "cherry", "Date", "Grape", "apricot");

        char targetChar = 'a';

        List<String> result = words.stream().
                filter(i -> i.indexOf(targetChar) == 1).
                map(String::toUpperCase).
                collect(Collectors.toList());

        System.out.println(result);

    }
}
