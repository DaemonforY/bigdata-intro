# -*- coding: utf-8 -*-
from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, DateType, FloatType, IntegerType, StringType

if __name__ == "__main__":
        spark = SparkSession .builder .appName("SparkSQL") .master('local').getOrCreate()
        sc = spark.sparkContext

        login_data = sc.parallelize([
            (1, "2024-01-01"),
            (1, "2024-01-03"),
            (1, "2024-01-05"),
            (2, "2024-01-02"),
            (2, "2024-01-04"),
            (2, "2024-01-06"),
            (3, "2024-01-01"),
            (3, "2024-01-05")])

        schema = StructType().add('user_id', IntegerType()).\
            add('date', StringType())
        df = login_data.toDF(schema)
        df.createOrReplaceTempView("log")

        sql = """
        select user_id, date 
        from(
            select *,lead(date) over(partition by user_id order by date) as time
            from log)
        where time is NULL
        """
        spark.sql(sql).show()