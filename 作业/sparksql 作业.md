## 作业 1： 连续冠军天数
## 作业 2：每个用户最长连续登录天数
```python
user_login_data = [
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
]
user_login_df = spark.createDataFrame(user_login_data, ["user_id", "login_date"])
user_login_df.createOrReplaceTempView("user_login")
```
## 作业 3： 每月Top3销售额商品
```python
sales_top3_data = [
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
]
sales_top3_df = spark.createDataFrame(sales_top3_data, ["date", "product", "sales"])
sales_top3_df.createOrReplaceTempView("sales")

```

## 作业 4： 累计销售额首次超过1000的日期
```python
sales_cumsum_data = [
    ("2024-01-01", "A", 200),
    ("2024-01-02", "A", 300),
    ("2024-01-03", "A", 250),
    ("2024-01-04", "A", 180),
    ("2024-01-05", "A", 200),
    ("2024-01-01", "B", 400),
    ("2024-01-02", "B", 300),
    ("2024-01-03", "B", 350),
    ("2024-01-04", "B", 150)
]
sales_cumsum_df = spark.createDataFrame(sales_cumsum_data, ["date", "product", "sales"])
sales_cumsum_df.createOrReplaceTempView("sales")

```
## 作业 5： 用户最近一次登录前的登录日期
```python
user_login_last_data = [
    (1, "2024-01-01"),
    (1, "2024-01-03"),
    (1, "2024-01-05"),
    (2, "2024-01-02"),
    (2, "2024-01-04"),
    (2, "2024-01-06"),
    (3, "2024-01-01"),
    (3, "2024-01-05")
]
user_login_last_df = spark.createDataFrame(user_login_last_data, ["user_id", "login_date"])
user_login_last_df.createOrReplaceTempView("user_login")

```










