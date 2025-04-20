package day02.homework;

import java.util.Optional;

public class optional_homework {
    /*
    使用Optional处理空值并打印默认消息，如果值不存在。
     */
    public static void main(String[] args) {
        String value1 = null;
        Optional optional1 = Optional.ofNullable(value1);
        System.out.println(optional1.orElse(1));
    }
}
