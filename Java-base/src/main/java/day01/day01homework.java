package day01;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Tests {

//    作业：
//    给定一个字符串, 统计每个字符出现的次数
//
//    String str = "alkfdjlaksjdf驾照驾照驾照加右轼林大戟是lkj 324lkj lkajsdflkjasdf;lakjsdfl;lakjsdf ";
//    a : 5
//    b : 2
//    驾 : 3

    public static void main(String[] args) {
        String str = "alkf" +
                "djlaksjdf驾照驾照驾照加右轼林大戟是lkj 324lkj lkajsdflkjasdf;lakjsdfl;lakjsdf ";
        Map<Character,Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
        }
        System.out.println(map);


    }
}