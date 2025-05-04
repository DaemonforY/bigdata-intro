# -*- coding: utf-8 -*-
from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, DateType, FloatType, IntegerType, StringType

if __name__ == "__main__":
        spark = SparkSession .builder .appName("SparkSQL") .master('local').getOrCreate()
        sc = spark.sparkContext

        login_data = sc.parallelize([
        (1, "2024-01-01"),
        (1, "2024-01-02"),
        (1, "2024-01-03"),
        (1, "2024-01-05"),
        (1, "2024-01-06"),
        (2, "2024-01-01"),
        (2, "2024-01-03"),
        (2, "2024-01-04"),
        (2, "2024-01-05"),
        (3, "2024-01-02"),
        (3, "2024-01-03"),
        (3, "2024-01-05")
        ])

        schema = StructType().add('user_id', IntegerType()).\
            add('date', StringType())
        df = login_data.toDF(schema)
        df.createOrReplaceTempView("log")

        sql = """
        SELECT 
        user_id,
        MAX(consecutive_days) AS max_consecutive_days
        FROM (
            SELECT 
                user_id,
                group_id,
                COUNT(*) AS consecutive_days
            FROM (
                SELECT 
                    user_id,
                    date,
                    SUM(new_group) OVER (PARTITION BY user_id ORDER BY date) AS group_id
                FROM (
                    SELECT 
                        user_id,
                        date,
                        CASE WHEN DATEDIFF(date, LAG(date) OVER (PARTITION BY user_id ORDER BY date)) = 1 
                             THEN 0 ELSE 1 END AS new_group
                    FROM log
                ) t1
            ) t2
            GROUP BY user_id, group_id
        ) t3
        GROUP BY user_id
        ORDER BY user_id;
        """
        spark.sql(sql).show()