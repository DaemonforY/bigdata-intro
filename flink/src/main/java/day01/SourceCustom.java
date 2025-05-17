package day01;

import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class SourceCustom {
    public static void main(String[] args) throws Exception{
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
//        env.addSource(new ClickSource()).print();

        //作业： 基于上面的source，进行每个用户的访问频次统计
        env.addSource(new ClickSource())
                // 提取用户并标记出现次数为1
                .map(event -> new Tuple2<>(event.getUser(), 1))
                .returns(Types.TUPLE(Types.STRING, Types.INT))
                // 按用户名分组
                .keyBy(0)
                // 滚动聚合计算总次数
                .sum(1)
                // 输出结果
                .print();

        env.execute("SourceCustom");
    }
}