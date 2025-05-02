# -*- coding: utf-8 -*-
from pyspark import SparkConf, SparkContext
import re

if __name__ == '__main__':
    conf = SparkConf().setMaster('local').setAppName('park')
    sc = SparkContext(conf=conf)

    rdd_1 = sc.parallelize(["Hello", "Hello", "Hello", "Hello", "Hello", "Spark", "Spark", "Spark"])
    acmlt = sc.accumulator(0)
    def func1(data):
        global acmlt
        if re.match(r'^H.*', data) is not None:
            acmlt += 1

    rdd_acmlt = rdd_1.foreach(func1)
    print(acmlt)