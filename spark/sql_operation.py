# -*- coding: utf-8 -*-
from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, DateType, FloatType, IntegerType, StringType, StructField, LongType

if __name__ == "__main__":
        spark = SparkSession .builder .appName("SparkSQL") .master('local').getOrCreate()
        sc = spark.sparkContext

        data = [
            (123, "dasfdasas", 3, 200, 1535945356, "2018-08-08"),
            (124, "dasfadass", 1, 200, 1535945356, "2018-08-08"),
            (125, "dadassfas", 3, 200, 1535945356, "2018-08-09"),
            (126, "dadassfas", 2, 200, 1535945356, "2018-08-09"),
            (127, "dasfdasas", 5, 200, 1535945356, "2018-08-09")
        ]

        schema = StructType([
            StructField("orderId", IntegerType(), nullable=False),
            StructField("userId", StringType(), nullable=False),
            StructField("productId", IntegerType(), nullable=False),
            StructField("price", IntegerType(), nullable=False),
            StructField("timestamp", LongType(), nullable=False),
            StructField("date", StringType(), nullable=False)
        ])

        df = spark.createDataFrame(data, schema=schema)
        df.createOrReplaceTempView("orders")
        df.printSchema()

        sql ='''
        SELECT 
            eu.userId,
            COALESCE(SUM(o.price), 0) AS yesterday_consumption
        FROM (
            SELECT 
                o.userId
            FROM orders o
            INNER JOIN (
                SELECT 
                    MAX(to_date(date, 'yyyy-MM-dd')) AS md 
                FROM orders
            ) md ON 1=1
            WHERE o.productId = 3
              AND to_date(o.date, 'yyyy-MM-dd') BETWEEN 
                  date_add(md.md, -29) 
                  AND md.md
            GROUP BY o.userId
            HAVING COUNT(DISTINCT o.date) = 30
        ) eu
        CROSS JOIN (
            SELECT 
                date_format(date_add(md, -1), 'yyyy-MM-dd') AS yd 
            FROM (
                SELECT MAX(to_date(date, 'yyyy-MM-dd')) AS md 
                FROM orders
            ) t
        ) yd
        LEFT JOIN orders o ON eu.userId = o.userId AND o.date = yd.yd
        GROUP BY eu.userId
        '''
        spark.sql(sql).show()
