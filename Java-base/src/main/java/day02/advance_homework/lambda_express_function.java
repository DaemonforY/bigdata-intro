package advance_homework;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class lambda_express_function {
    /*
    Lambda表达式和函数式接口设计

- 作业描述：设计一个函数式接口Transformer<T, R>，该接口包含一个方法R transform(T input)。使用Lambda表达式实现以下功能：
- 将字符串列表转换为大写。
- 计算整数列表每个元素的平方。
- 将双精度浮点数列表四舍五入到整数。
- 要求：创建多个Lambda表达式并应用到列表上，结合使用Java的内置函数式接口。
     */
    public static void main(String[] args) {
        List<String> list = Arrays.asList("dsadas","sdsada","sdad");
        Transformer<String, String> toUpperCase1 = String::toUpperCase;
        List<String> string1 = transformList(list, toUpperCase1);
        System.out.println(string1);

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Transformer<Integer, Integer> squre = x -> x * x;
        List<Integer> result = transformList(numbers, squre);
        System.out.println(result);

        List<Double> dubles = Arrays.asList(1.0,2.0,3.0,4.0,5.7,6.3,7.0,8.0);
        Transformer<Double, Integer> round = i -> (int) Math.round(i);
        List<Integer> result1 = transformList(dubles, round);
        System.out.println(result1);
    }

    private static <T, R> List<R> transformList(List<T> list, Transformer<T, R> transformer) {
        return list.stream()
                .map(transformer::transform)
                .collect(Collectors.toList());
    }
}

interface Transformer<T, R>{
    R transform(T t);
}