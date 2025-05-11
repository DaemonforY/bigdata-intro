package day01;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class SourceCustom {
    public static void main(String[] args) throws Exception{
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.addSource(new ClickSource()).print();

        //作业： 基于上面的source，进行每个用户的访问频次统计

        env.execute("SourceCustom");
    }
}