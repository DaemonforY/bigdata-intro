import day01.DisplayMessage;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Tests {

//    作业：
//    给定一个字符串, 统计每个字符出现的次数
//
//    String str = "alkfdjlaksjdf驾照驾照驾照加右轼林大戟是lkj 324lkj lkajsdflkjasdf;lakjsdfl;lakjsdf ";
//    a : 5
//    b : 2
//    驾 : 3


    public static void main(String[] args) {
        String str = "alkfdjlaksjdf驾照驾照驾照加右轼林大戟是lkj 324lkj lkajsdflkjasdf;lakjsdfl;lakjsdf ";
        Map<Character,Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        System.out.println(map);

    }

    @Test
    public void test() {
        Runnable hello = new DisplayMessage("Hello");
        Thread thread1 = new Thread(hello);
        thread1.setDaemon(true);
        thread1.setName("hello");
        System.out.println("Starting hello thread...");
        thread1.start();
    }
}
