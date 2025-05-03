from pyspark.sql import SparkSession

spark = SparkSession.builder.appName("ChampionDays").getOrCreate()

sales_data = [
    ("2024-01-01", "B", 200),
    ("2024-01-02", "A", 220),
    ("2024-01-03", "A", 250),
    ("2024-01-04", "A", 260),
    ("2024-01-05", "A", 300),
    ("2024-01-06", "B", 260),
    ("2024-01-07", "B", 300),
    ("2024-01-08", "A", 250),
    ("2024-01-09", "A", 260),
    ("2024-01-10", "A", 300)
]
sales_df = spark.createDataFrame(sales_data, ["date", "product", "sales"])
sales_df.createOrReplaceTempView("sales")

# 每个产品出现的连续天数
sql = """
select product,init_date,count(1) cnt
FROM (
        select *,date_add(date,-rn+1) as init_date,date
        FROM (
                select *, row_number() over(partition by product order by date) as rn
                from sales
                order by date
        ) 
)
group by product,init_date
"""

spark.sql(sql).show()

