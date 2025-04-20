package advance_homework;

import java.util.*;
import java.util.stream.Collectors;

public class complex_data_stream {
    /*
    复杂数据处理与Stream API

- 作业描述：给定一个包含多个用户信息的列表，每个用户包括姓名、年龄和爱好列表。使用Stream API完成以下操作：
  - 筛选出年龄在18岁以上的用户。
  - 将所有用户的爱好合并成一个列表，并去除重复的爱好。
  - 找出最常见的爱好并输出。
- 要求：使用filter、map、flatMap以及Collectors等高级Stream操作。
     */
    public static void main(String[] args) {
        List<user> list = Arrays.asList(
                new user("张三", 20, Arrays.asList("篮球", "音乐", "旅游")),
                new user("李四", 17, Arrays.asList("音乐", "电影", "游戏")),
                new user("王五", 22, Arrays.asList("旅游", "摄影", "篮球")),
                new user("赵六", 19, Arrays.asList("游戏", "编程", "音乐"))
        );

        System.out.println(list.stream().
                filter(i -> i.getAge()>18).
                collect(Collectors.toList()));

        System.out.println(list.stream().
                flatMap(i -> i.getHobby().stream()).
                distinct().
                collect(Collectors.toList()));

        System.out.println(list.stream()
                .flatMap(user -> user.getHobby().stream())
                .collect(Collectors.groupingBy(
                        hobby -> hobby,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null));
    }
}

class user {
    private String name;
    private int age;
    private List<String> hobby;

    public user(String name, int age, List<String> hobby) {
        this.name = name;
        this.age = age;
        this.hobby = hobby;
    }

    public String getName(){return name;}
    public int getAge(){return age;}
    public List<String> getHobby(){return hobby;}

    @Override
    public String toString(){
        return name + " " + age + " " + hobby;
    }
}