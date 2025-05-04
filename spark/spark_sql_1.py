# -*- coding: utf-8 -*-
from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, DateType, FloatType, IntegerType, StringType

if __name__ == "__main__":
    spark = SparkSession .builder .appName("SparkSQL") .master('local').getOrCreate()
    sc = spark.sparkContext

    sales_data = sc.parallelize([
        ("2024-01-01", "A", 100),
        ("2024-01-01", "B", 200),
        ("2024-01-01", "C", 150),
        ("2024-01-02", "A", 220),
        ("2024-01-02", "B", 210),
        ("2024-01-02", "C", 180),
        ("2024-01-03", "A", 250),
        ("2024-01-03", "B", 210),
        ("2024-01-03", "C", 200),
        ("2024-01-04", "A", 180),
        ("2024-01-04", "B", 260),
        ("2024-01-04", "C", 170),
        ("2024-01-05", "A", 300),
        ("2024-01-05", "B", 210),
        ("2024-01-05", "C", 250)
    ])

    schema = StructType().add('date', StringType()).\
        add('product', StringType()).\
        add('sales', IntegerType())
    df = sales_data.toDF(schema)
    df.createOrReplaceTempView("sales")

    sql =  '''
    SELECT product, MAX(consecutive_days) AS max_consecutive_days
    FROM (
        SELECT product, group_id, COUNT(*) AS consecutive_days
        FROM (
            SELECT product, date,
                   SUM(break_flag) OVER (PARTITION BY product ORDER BY date) AS group_id
            FROM (
                SELECT product, date,
                       CASE WHEN DATEDIFF(date, LAG(date) OVER (PARTITION BY product ORDER BY date)) > 1 
                            THEN 1 ELSE 0 END AS break_flag
                FROM (
                    SELECT date, product
                    FROM (
                        SELECT date, product, 
                               ROW_NUMBER() OVER (PARTITION BY date ORDER BY sales DESC) AS rank
                        FROM sales
                    ) 
                    WHERE rank = 1
                )
            )
        )
        GROUP BY product, group_id
    )
GROUP BY product
ORDER BY max_consecutive_days DESC
LIMIT 1;
        
    '''
    spark.sql(sql).show()