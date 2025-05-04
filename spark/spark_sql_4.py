# -*- coding: utf-8 -*-
from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, DateType, FloatType, IntegerType, StringType

if __name__ == "__main__":
        spark = SparkSession .builder .appName("SparkSQL") .master('local').getOrCreate()
        sc = spark.sparkContext

        login_data = sc.parallelize([
    ("2024-01-01", "A", 200),
    ("2024-01-02", "A", 300),
    ("2024-01-03", "A", 250),
    ("2024-01-04", "A", 180),
    ("2024-01-05", "A", 200),
    ("2024-01-01", "B", 400),
    ("2024-01-02", "B", 300),
    ("2024-01-03", "B", 350),
    ("2024-01-04", "B", 150)
])

        schema = StructType().add('date', StringType()).\
            add('product', StringType()).\
            add('sales', IntegerType())
        df = login_data.toDF(schema)
        df.createOrReplaceTempView("sale")

        sql = """
        SELECT * FROM (
            SELECT date, daily_sales,
                   SUM(daily_sales) OVER (ORDER BY date) AS total_sales
            FROM (
                SELECT date, SUM(sales) AS daily_sales
                FROM sale
                GROUP BY date
            )
        ) 
        WHERE total_sales > 1000 limit 1
        """
        spark.sql(sql).show()