package day02;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream01 {
    public static void main(String[] args) {

        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> collect = strings
                .stream()
                .filter(string -> !string.isEmpty())
                .collect(Collectors.toList());
        System.out.println(collect);
        System.out.println("------------------------------------------------------");
        Random random = new Random();
        random.ints().limit(5).sorted().forEach(System.out::println);

        System.out.println("------------------------------------------------------");
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5, -2);
        // 获取对应的平方数
        List<Integer> squaresList = numbers
                .stream()
                .distinct()
                .map(i -> i * i)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(squaresList);
    }
}
