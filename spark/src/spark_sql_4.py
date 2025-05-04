# -*- coding: utf-8 -*-
from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, DateType, FloatType, IntegerType, StringType

if __name__ == "__main__":
        spark = SparkSession .builder .appName("SparkSQL") .master('local').getOrCreate()
        sc = spark.sparkContext

        login_data = sc.parallelize([
    ("2024-01-01", "A", 100),
    ("2024-01-02", "B", 200),
    ("2024-01-03", "C", 150),
    ("2024-01-15", "D", 250),
    ("2024-01-20", "E", 180),
    ("2024-02-01", "A", 300),
    ("2024-02-02", "B", 220),
    ("2024-02-03", "C", 210),
    ("2024-02-10", "D", 280),
    ("2024-02-20", "E", 190)
])

        schema = StructType().add('date', StringType()).\
            add('product', StringType()).\
            add('sales', IntegerType())
        df = login_data.toDF(schema)
        df.createOrReplaceTempView("sale")

        sql = """
        SELECT 
            month,
            product,
            total_sales,
            sales_rank
        FROM (
            SELECT 
                DATE_FORMAT(date, 'yyyy-MM') AS month,
                product,
                SUM(sales) AS total_sales,
                ROW_NUMBER() OVER (PARTITION BY DATE_FORMAT(date, 'yyyy-MM') ORDER BY SUM(sales) DESC) AS sales_rank
            FROM sale
            GROUP BY DATE_FORMAT(date, 'yyyy-MM'), product
        ) ranked_sales
        WHERE sales_rank <= 3
        ORDER BY month, sales_rank
        """
        spark.sql(sql).show()