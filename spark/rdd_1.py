# -*- coding: utf-8 -*-
import json

from pyspark import SparkConf, SparkContext

if __name__ == "__main__":
    conf = SparkConf().setMaster("local").setAppName("Spark")
    sc = SparkContext(conf=conf)

    # textFile读文件
    rdd1 = sc.textFile('../作业/agent.log')

    # 对数据进行分割
    rdd_map = rdd1.map(lambda x : x.split(' '))

    # 使用map将需要的数据创建一个元组
    rdd_province_advertised = rdd_map.map(lambda x : ((x[1], x[4]), 1))

    # 将每个城市的广告数据进行聚合
    rdd_reduce = rdd_province_advertised.reduceByKey(lambda x, y : x + y)

    # 重组数据为 (省份, (广告, 点击量))
    rdd_groupable = rdd_reduce.map(lambda x: (x[0][0], (x[0][1], x[1])))

    # 按省份分组
    grouped_by_province = rdd_groupable.groupByKey()

    # 对数据进行排序
    rdd_sort = grouped_by_province.sortByKey()

    # 对每个省份的广告按点击量降序排序，取前3
    top3_ads = rdd_sort.flatMapValues(
        lambda values: sorted(values, key=lambda v: -v[1])[:3]
    )

    # 打印结果
    print(top3_ads.collect())
    sc.stop()