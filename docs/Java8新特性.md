## 教学大纲
1. Lambda表达式
   - 语法介绍
   - 函数式接口 (FunctionalInterface)
   - 示例与应用场景
   - 作业：使用Lambda表达式对列表进行筛选与排序
2. Stream API
   - Stream的概念与分类（流的惰性求值与及早求值）
   - 常用操作（filter、map、reduce、collect等）
   - 并行流（Parallel Streams）
   - 作业：用Stream API对数据进行聚合和转换
3. 新时间日期API
   - java.time包简介
   - LocalDate、LocalTime、LocalDateTime
   - 日期时间格式化与解析
   - 作业：使用新日期API计算两个日期的差异
4. 默认方法和静态方法（接口的新特性）
   - 默认方法概念与使用
   - 使用场景与目标
   - 作业：定义一个接口并使用默认方法实现一些逻辑
5. Optional类
   - 使用Optional避免空指针异常
   - 创建、能否互相组合、变换与过滤
   - 作业：使用Optional类优化空值处理逻辑
6. Nashorn JavaScript引擎
   - Nashorn简介与应用
   - 在Java中执行JavaScript代码
   - 作业：使用Nashorn执行简单的JavaScript逻辑
7. 重复注解
   - 重复注解使用场景
   - 创建自定义重复注解
   - 作业：创建一个自定义重复注解并应用到多个方法上
8. 类型注解
   - 类型注解概念与使用
   - 使用场景与目标
   - 作业：使用类型注解验证泛型类型安全
9. 新增静态方法引用
   - 方法引用的概念与使用
   - 示例讲解（静态方法引用、特定对象的实例方法引用等）
   - 作业：使用方法引用代替循环操作
## 作业练习
1. Lambda表达式练习：
   - 编写一个程序，使用Lambda表达式过滤列表中的奇数，并对结果进行排序。
2. Stream API练习：
   - 使用Stream API从字符串列表中筛选包含指定字符的元素，并将其转换为大写。
3. 日期API练习：
   - 使用LocalDate类计算某个日期15天后的日期，并格式化输出。
4. Optional练习：
   - 使用Optional处理空值并打印默认消息，如果值不存在。
5. 接口默认方法练习：
   - 定义一个接口Vehicle，其中包括一个默认方法honk，然后在接口的实现类中调用这个默认方法。 
## 高质量作业
1. 复杂数据处理与Stream API
   - 作业描述：给定一个包含多个用户信息的列表，每个用户包括姓名、年龄和爱好列表。使用Stream API完成以下操作：
     - 筛选出年龄在18岁以上的用户。
     - 将所有用户的爱好合并成一个列表，并去除重复的爱好。
     - 找出最常见的爱好并输出。
   - 要求：使用filter、map、flatMap以及Collectors等高级Stream操作。
2. Lambda表达式和函数式接口设计
   - 作业描述：设计一个函数式接口Transformer<T, R>，该接口包含一个方法R transform(T input)。使用Lambda表达式实现以下功能：
   - 将字符串列表转换为大写。
   - 计算整数列表每个元素的平方。
   - 将双精度浮点数列表四舍五入到整数。
   - 要求：创建多个Lambda表达式并应用到列表上，结合使用Java的内置函数式接口。
3. 日期时间API综合应用
   - 作业描述：编写一个日程安排程序，要求包括以下功能：
   - 可输入一个日期并计算到该日期的剩余天数。
   - 输入两个日期，计算它们之间的周数差异。
   - 格式化输出当前日期为YYYY/MM/DD格式。
   - 可根据定义的时间段（如早上、下午、晚上）输出问候语。
   - 要求：使用LocalDate、Period、LocalTime、DateTimeFormatter等API。
4. Optional与异常处理结合
   - 作业描述：编写一个简单的订单处理系统，其中包括以下功能：
   - 验证输入订单是否存在，不存在则输出警告。
   - 对存在的订单，检查是否已支付，未支付则抛出自定义异常。
   - 计算订单总金额，并使用Optional包装返回。
   - 要求：结合使用Optional的ifPresent、orElseThrow等方法，设计一个自定义异常类。
5. 接口默认方法扩展与应用
   - 作业描述：设计一个库存管理接口Inventory，要求包括以下功能：
   - 一个默认方法showInventory，用来显示当前库存情况。
   - 一个静态方法calcTotalValue，计算库存商品总价值。
   - 子接口ElectronicInventory与GroceryInventory，继承Inventory并扩展各自特有的方法。
   - 要求：实现接口的一个或多个子类，并演示这些扩展功能。