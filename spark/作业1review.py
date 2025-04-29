# -*- coding: utf-8 -*-
from pyspark import SparkConf, SparkContext

def top3_ads_func(list1, list2):
    # 合并两个top3列表，然后取前3
    merged = list1 + list2
    merged_sorted = sorted(merged, key=lambda x: -x[1])[:3]
    return merged_sorted

if __name__ == "__main__":
    conf = SparkConf().setMaster("local").setAppName("Spark")
    sc = SparkContext(conf=conf)

    rdd1 = sc.textFile('agent.log')
    rdd_map = rdd1.map(lambda x: x.split(' '))
    # 1. 统计每个(省份,广告)的点击量
    rdd_province_ad = rdd_map.map(lambda x: ((x[1], x[4]), 1))
    rdd_count = rdd_province_ad.reduceByKey(lambda x, y: x + y)
    # 2. 变成(省份, (广告, 点击量))
    rdd_province_to_adcount = rdd_count.map(lambda x: (x[0][0], [(x[0][1], x[1])]))
    # 3. 用reduceByKey维护每个省份的top3广告
    rdd_top3 = rdd_province_to_adcount.reduceByKey(top3_ads_func)
    # 4. 排序并加上排名
    results = rdd_top3.flatMapValues(
        lambda ad_list: [(ad, count, idx+1) for idx, (ad, count) in enumerate(sorted(ad_list, key=lambda x: -x[1]))]
    ).collect()

    for province, (ad, count, rank) in results:
        print(f"省份: {province}, 广告: {ad}, 点击量: {count}, 排名: {rank}")

    sc.stop()
