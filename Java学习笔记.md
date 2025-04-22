## Java学习

#### Java基本语法

- 1.大小写敏感 

- 2.类名首字母应该大写 (e.g. MyFunction)

- 3.方法名应该以小写字母开头 

- 4.源文件名必须和类名相同

#### Java变量

- 局部变量
  * 在方法，构造函数内部声明的变量，只在其声明的范围内有效，在执行结束后销毁
- 类变量(静态变量)
  * 使用static关键词修饰的变量，属于类本身，所有实例共享，程序结束时销毁

- 成员变量(非静态变量)
  - 在类中声明且没有使用static修饰的变量，属于对象实例，作用在整个类内部，需要通过对象访问，在创建对象是初始化，对象被回收是销毁

#### Java枚举

Java 5.0引入了枚举，枚举限制变量只能是预先设定好的值。使用枚举可以减少代码中的 bug。

例如，我们为果汁店设计一个程序，它将限制果汁为小杯、中杯、大杯。这就意味着它不允许顾客点除了这三种尺寸外的果汁。

``` 
class FreshJuice {
   enum FreshJuiceSize{ SMALL, MEDIUM , LARGE }
   FreshJuiceSize size;
}

public class FreshJuiceTest {
   public static void main(String[] args){
      FreshJuice juice = new FreshJuice();
      juice.size = FreshJuice.FreshJuiceSize.MEDIUM  ;
   }
} 
```

#### Java对象和类

Java是面向对象的编程语言，基本概念为：

- 类（public class ...)

  - 定义对象的属性和方法

- 对象 （Car myCar = new Car();）

  - 类的实例，具有状态和行为

- 继承（public class Dog extends Animal）

  - 一个类可以继承另一个类的属性和方法

- 封装

  - 将对象的状态私有化，只能通过公共方法访问

    - ``` 
      private String name;
      public String getName() {return name;}
      ```

- 多态

  - 对象可以表现为多种形态，主要通过方法重载和方法重写实现。
  
- 抽象

  - 使用抽象类和接口来定义必须实现的方法，不提供具体实现


#### 类和对象

- 对象：对象是一个实例，有状态和行为，例如：一条狗是一个对象，状态有：颜色，名字；行为有：叫，摇尾巴。是真实存在的具体东西
- 类：类是一个模板，描述一类对象的行为和状态，是对象共同特征的描述
- 在设计时：名词一般为属性；动词一般为行为

##### 定义类的补充事项

- 用来描述一类事物的类 一般为Javabean类
- 在Javabean类中，不写main方法
- 编写main方法的类叫做测试类
- 可以在测试类中创建Javabean类的对象并进行赋值调用

##### 一个Java文件中可以定义多个class类，且只能一个类是public修饰，而且public修饰的类名必须成为代码文件名，一般在开发中还是建议一个文件定义一个class类

### 标准的JavaBean类

- 类名需要见名知意
- 成员变量使用private修饰
- 提供至少两个构造方法
  - 无参构造方法
  - 带全部参数的构造方法
- 成员方法
  - 提供每一个成员变量对应的set()/get()





## Java基本数据类型

### 基本数据类型对应的包装类

```
基本类型：byte 二进制位数：8
包装类：java.lang.Byte
最小值：Byte.MIN_VALUE=-128
最大值：Byte.MAX_VALUE=127

基本类型：short 二进制位数：16
包装类：java.lang.Short
最小值：Short.MIN_VALUE=-32768
最大值：Short.MAX_VALUE=32767

基本类型：int 二进制位数：32
包装类：java.lang.Integer
最小值：Integer.MIN_VALUE=-2147483648
最大值：Integer.MAX_VALUE=2147483647

基本类型：long 二进制位数：64
包装类：java.lang.Long
最小值：Long.MIN_VALUE=-9223372036854775808
最大值：Long.MAX_VALUE=9223372036854775807

基本类型：float 二进制位数：32
包装类：java.lang.Float
最小值：Float.MIN_VALUE=1.4E-45
最大值：Float.MAX_VALUE=3.4028235E38

基本类型：double 二进制位数：64
包装类：java.lang.Double
最小值：Double.MIN_VALUE=4.9E-324
最大值：Double.MAX_VALUE=1.7976931348623157E308

基本类型：char 二进制位数：16
包装类：java.lang.Character
最小值：Character.MIN_VALUE=0
最大值：Character.MAX_VALUE=65535
```

### 基本数据类型的默认值

```
Bool     :false
Byte     :0
Character:
Double   :0.0
Float    :0.0
Integer  :0
Long     :0
Short    :0
String   :null
```

## 面向对象编程进阶

### 常见的类

- Jvabean类 用来描述一类事物的类
- 测试类 用来检查其他类是否书写正确，带有main方法的类，是程序的入口
- 工具类 帮助做事，但是步描述任何事物的类

### static关键词

##### 注意事项

- 静态方法只能访问静态变量和静态方法
- 非静态方法可以访问静态变量或者静态方法，也可以访问非静态的成员变量和非静态的成员方法
- 静态方法中没有this关键词

非静态方法默认带有this，是调用者的地址；

被static修饰的成员变量叫做静态变量，修饰的成员方法叫做静态方法#

## 继承

语法：

``` 
public class 子类 extends 父类{}
```

- 当类与类之间，存在相同的内容，并且满足子类是父类中的一种，就可以使用继承

- 子类只能访问父类非私有的成员

- 继承中成员变量访问特点是先在局部位置找，本类成员位置找，父类成员位置找，逐级往上

- 继承中构造方法的访问特点

  - 子类不能继承父类的构造方法，但是可以通过super调用
  - 子类构造方法的第一行，有一个默认的super();
  - 默认先访问父类中无参的构造方法，再执行自己

- 方法重写

  - 当父类中方法不能满足现在的需求是，需要要将这个方法进行重写，本质是覆盖虚方法表中的方法
  - 子类重写的方法上面需要加上@override

- this,super使用

  - this: 理解为一个变量，表示当前方法调用者的地址值；
  - super: 代表父类的存储空间

- 封装：对象代表什么，就要封装对应的数据，并提供数据对应的行为

- 多态

  - 多态是对象的多种形态
  - 多态的前提
    - 有继承/实现关系
    - 有父类引用指向子类对象
    - 有方法的重写
  - 多态的好处是使用父类型作为参数，可以接受所有子类对象，体现多态的扩展性
  - 多态的坏处是不能使用子类的特有功能

- 在调用一个方法时，如果参数是一个类的名字，那么就可以传入这个类所有的子类对象

- 接口：对行为的抽象

  - 接口用关键字interface定义

    - ``` 
      public interface 接口名{}
      ```

  - 接口不能实例化

  - 接口和类之间是实现关系，通过implements关键词实现

    - ``` 
      public class 类名 implements 接口名{}
      ```

  - 接口的子类（实现类）

    - 要么重写接口中的所有抽象方法，要么是抽象类

## 正则表达式

### 方法调用

**java.util.regex** 包是 Java 标准库中用于支持正则表达式操作的包。

java.util.regex 包主要包括以下三个类：

- Pattern 类：

  pattern 对象是一个正则表达式的编译表示。Pattern 类没有公共构造方法。要创建一个 Pattern 对象，你必须首先调用其公共静态编译方法，它返回一个 Pattern 对象。该方法接受一个正则表达式作为它的第一个参数。

- Matcher 类：

  Matcher 对象是对输入字符串进行解释和匹配操作的引擎。与Pattern 类一样，Matcher 也没有公共构造方法。你需要调用 Pattern 对象的 matcher 方法来获得一个 Matcher 对象。

- PatternSyntaxException：

  PatternSyntaxException 是一个非强制异常类，它表示一个正则表达式模式中的语法错误。

### 使用示例

``` java
import java.util.regex.*;
 
class RegexExample1{
   public static void main(String[] args){
      String content = "I am noob " +
        "from runoob.com.";
 
      String pattern = ".*runoob.*";
 
      boolean isMatch = Pattern.matches(pattern, content);
      System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);
   }
}
```

输出

``` 
字符中是否包含了 'runoob' 子字符串？ true
```

## Java日期时间

java.util 包提供了 Date 类来封装当前的日期和时间。 Date 类提供两个构造函数来实例化 Date 对象。

第一个构造函数使用当前日期和时间来初始化对象。

 	Date( )

第二个构造函数接收一个参数，该参数是从 1970 年 1 月 1 日起的毫秒数。

​	Date(long millisec)

Date 对象创建以后，可以调用下面的方法。

| 序号 | 方法和描述                                                   |
| :--- | :----------------------------------------------------------- |
| 1    | **boolean after(Date date)** 若当调用此方法的Date对象在指定日期之后返回true,否则返回false。 |
| 2    | **boolean before(Date date)** 若当调用此方法的Date对象在指定日期之前返回true,否则返回false。 |
| 3    | **Object clone( )** 返回此对象的副本。                       |
| 4    | **int compareTo(Date date)** 比较当调用此方法的Date对象和指定日期。两者相等时候返回0。调用对象在指定日期之前则返回负数。调用对象在指定日期之后则返回正数。 |
| 5    | **int compareTo(Object obj)** 若obj是Date类型则操作等同于compareTo(Date) 。否则它抛出ClassCastException。 |
| 6    | **boolean equals(Object date)** 当调用此方法的Date对象和指定日期相等时候返回true,否则返回false。 |
| 7    | **long getTime( )** 返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。 |
| 8    | **int hashCode( )**  返回此对象的哈希码值。                  |
| 9    | **void setTime(long time)**   用自1970年1月1日00:00:00 GMT以后time毫秒数设置时间和日期。 |
| 10   | **String toString( )** 把此 Date 对象转换为以下形式的 String： dow mon dd hh:mm:ss zzz yyyy 其中： dow 是一周中的某一天 (Sun, Mon, Tue, Wed, Thu, Fri, Sat)。 |

### 获取当前日期时间实例

```java
import java.util.Date;
  
public class DateDemo {
   public static void main(String[] args) {
       // 初始化 Date 对象
       Date date = new Date();
        
       // 使用 toString() 函数显示日期时间
       System.out.println(date.toString());
   }
}
```

### 日期比较

Java使用以下三种方法来比较两个日期：

- 使用 getTime() 方法获取两个日期（自1970年1月1日经历的毫秒数值），然后比较这两个值。
- 使用方法 before()，after() 和 equals()。例如，一个月的12号比18号早，则 new Date(99, 2, 12).before(new Date (99, 2, 18)) 返回true。
- 使用 compareTo() 方法，它是由 Comparable 接口定义的，Date 类实现了这个接口。

### 使用 SimpleDateFormat 格式化日期

SimpleDateFormat 是一个以语言环境敏感的方式来格式化和分析日期的类。SimpleDateFormat 允许你选择任何用户自定义日期时间格式来运行。例如：

``` java
import  java.util.*;
import java.text.*;
 
public class DateDemo {
   public static void main(String[] args) {
 
      Date dNow = new Date( );
      SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
 
      System.out.println("当前时间为: " + ft.format(dNow));
   }
}
```

这一行代码确立了转换的格式，其中 yyyy 是完整的公元年，MM 是月份，dd 是日期，HH:mm:ss 是时、分、秒。

**注意**:有的格式大写，有的格式小写，例如 MM 是月份，mm 是分；HH 是 24 小时制，而 hh 是 12 小时制。



### 使用printf格式化日期

printf 方法可以很轻松地格式化时间和日期。使用两个字母格式，它以 **%t** 开头并且以下面表格中的一个字母结尾。

- %tY：输出四位数的年份，例如：2023
- %ty：输出两位数的年份，例如：23
- %tm：输出两位数的月份，例如：02
- %tB：输出月份的全名，例如：February
- %tb：输出月份的缩写，例如：Feb
- %tA：输出星期的全名，例如：Wednesday
- %ta：输出星期的缩写，例如：Wed
- %td：输出两位数的日期，例如：24
- %te：输出一位或两位数的日期，例如：24 或 02
- %tH：输出24小时制的小时数，例如：23
- %tI：输出12小时制的小时数，例如：11
- %tM：输出分钟数，例如：45
- %tS：输出秒数，例如：30
- %tp：输出上午还是下午，例如：AM 或 PM
- %tZ：输出时区，例如：GMT+08:00

| 转换符 | 说明                        | 示例                             |
| :----- | :-------------------------- | :------------------------------- |
| %tc    | 包括全部日期和时间信息      | 星期六 十月 27 14:21:20 CST 2007 |
| %tF    | "年-月-日"格式              | 2007-10-27                       |
| %tD    | "月/日/年"格式              | 10/27/07                         |
| %tr    | "HH:MM:SS PM"格式（12时制） | 02:25:51 下午                    |
| %tT    | "HH:MM:SS"格式（24时制）    | 14:28:16                         |
| %tR    | "HH:MM"格式（24时制）       | 14:28                            |

``` java
import java.util.Date;
 
public class DateDemo {
 
  public static void main(String[] args) {
     // 初始化 Date 对象
     Date date = new Date();
 
     //c的使用  
    System.out.printf("全部日期和时间信息：%tc%n",date);          
    //f的使用  
    System.out.printf("年-月-日格式：%tF%n",date);  
    //d的使用  
    System.out.printf("月/日/年格式：%tD%n",date);  
    //r的使用  
    System.out.printf("HH:MM:SS PM格式（12时制）：%tr%n",date);  
    //t的使用  
    System.out.printf("HH:MM:SS格式（24时制）：%tT%n",date);  
    //R的使用  
    System.out.printf("HH:MM格式（24时制）：%tR",date);  
  }
}
```

```
全部日期和时间信息：星期一 九月 10 10:43:36 CST 2012  
年-月-日格式：2012-09-10  
月/日/年格式：09/10/12  
HH:MM:SS PM格式（12时制）：10:43:36 上午  
HH:MM:SS格式（24时制）：10:43:36  
HH:MM格式（24时制）：10:43  
```

### Java 休眠(sleep)

sleep()使当前线程进入停滞状态（阻塞当前线程），让出CPU的使用、目的是不让当前线程独自霸占该进程所获的CPU资源，以留一定时间给其他线程执行的机会。

``` java
import java.util.*;
  
public class SleepDemo {
   public static void main(String[] args) {
      try { 
         System.out.println(new Date( ) + "\n"); 
         Thread.sleep(1000*3);   // 休眠3秒
         System.out.println(new Date( ) + "\n"); 
      } catch (Exception e) { 
          System.out.println("Got an exception!"); 
      }
   }
}
```



## Java数据结构

Java 提供了丰富的数据结构，主要通过 **Java 集合框架（Java Collections Framework, JCF）** 来实现。这些数据结构可以分为两大类：**线性结构** 和 **非线性结构**。以下是主要的数据结构及其特点：

- **1.线性数据结构**

- #### **(1) 数组（Array）**

  - **特点**：固定大小、连续内存、索引访问快（O(1)）。
  - **实现类**：`int[]`, `String[]` 等原生数组。
  - **适用场景**：已知大小、频繁随机访问。

  #### **(2) 动态数组（ArrayList）**

  - **特点**：基于数组实现，自动扩容（O(n) 插入/删除）。
  - **实现类**：`java.util.ArrayList`。
  - **适用场景**：需要动态大小且频繁随机访问。

  #### **(3) 链表（LinkedList）**

  - **特点**：双向链表，插入/删除快（O(1)），随机访问慢（O(n)）。
  - **实现类**：`java.util.LinkedList`。
  - **适用场景**：频繁插入/删除，较少随机访问。

- #### **2.非线性数据结构**

- #### **1. HashSet（哈希集合）**

  - **特点**：

    - 基于 `HashMap` 实现，只存储 **唯一元素**（不允许重复）。
    - 内部使用 `HashMap` 的 `Key` 存储元素，`Value` 统一为一个 `PRESENT`（虚拟对象）。
    - 无序（不保证插入顺序），允许 `null` 值。
    - 查找、插入、删除的平均时间复杂度为 **O(1)**（哈希冲突时可能退化到 O(n)）。

  - **核心方法**：

    ```java
    HashSet<String> set = new HashSet<>();
    set.add("A");  // 添加元素
    set.contains("A");  // 判断是否包含
    set.remove("A");  // 删除元素
    ```

  - **适用场景**：

    - 去重（如统计唯一单词）。
    - 快速判断元素是否存在（如黑名单过滤）。

- #### **2. HashMap（哈希映射）**

  - **特点**：

    - 存储 **键值对（Key-Value）**，`Key` 唯一，`Value` 可重复。
    - 基于 **数组 + 链表/红黑树**（Java 8 优化，链表长度 ≥8 时转红黑树）。
    - 无序（`LinkedHashMap` 可保持插入顺序），允许 `null` 键和 `null` 值。
    - 查找、插入、删除的平均时间复杂度为 **O(1)**。

  - **核心方法**：

    java

    ```java
    HashMap<String, Integer> map = new HashMap<>();
    map.put("Key", 100);  // 添加键值对
    map.get("Key");       // 获取值
    map.containsKey("Key"); // 判断键是否存在
    ```

  - **适用场景**：

    - 缓存（如 `Redis` 的键值存储）。
    - 快速通过 `Key` 访问数据（如数据库索引）。

### **ArrayList 常用方法**

`ArrayList` 是 Java 中最常用的动态数组实现，基于数组实现，支持动态扩容。以下是它的核心方法及使用示例：

------

### **1. 添加元素**

#### **(1) `add(E element)`**

- **作用**：在列表末尾添加元素。

- **时间复杂度**：平均 **O(1)**（扩容时为 O(n)）。

- 示例

  ```java
  ArrayList<String> list = new ArrayList<>();
  list.add("Apple");  // ["Apple"]
  list.add("Banana"); // ["Apple", "Banana"]
  ```

#### **(2) `add(int index, E element)`**

- **作用**：在指定索引位置插入元素。

- **时间复杂度**：**O(n)**（需要移动后续元素）。

- 示例

  ```java
  list.add(1, "Orange"); // ["Apple", "Orange", "Banana"]
  ```

------

### **2. 获取元素**

#### **(1) `get(int index)`**

- **作用**：返回指定索引位置的元素。

- **时间复杂度**：**O(1)**（数组随机访问）。

- 示例

  ```java
  String fruit = list.get(1); // "Orange"
  ```

#### **(2) `size()`**

- **作用**：返回列表当前元素数量。

- 示例

  ```java
  int size = list.size(); // 3
  ```

------

### **3. 删除元素**

#### **(1) `remove(int index)`**

- **作用**：删除指定索引位置的元素，并返回被删除的元素。

- **时间复杂度**：**O(n)**（需要移动后续元素）。

- 示例

  ```java
  String removed = list.remove(0); // 删除 "Apple"，返回 "Apple"
  // 剩余列表：["Orange", "Banana"]
  ```

#### **(2) `remove(Object o)`**

- **作用**：删除第一个匹配的元素（按 `equals()` 判断）。

- **时间复杂度**：**O(n)**（需要遍历查找）。

- 示例

  ```java
  boolean isRemoved = list.remove("Banana"); // true，列表变为 ["Orange"]
  ```

------

### **4. 修改元素**

#### **(1) `set(int index, E element)`**

- **作用**：替换指定索引位置的元素，并返回旧值。

- **时间复杂度**：**O(1)**。

- 示例

  ```java
  String oldVal = list.set(0, "Grape"); // "Orange" 被替换为 "Grape"
  ```

------

### **5. 查找元素**

#### **(1) `contains(Object o)`**

- **作用**：判断列表是否包含指定元素。

- **时间复杂度**：**O(n)**（遍历查找）。

- 示例

  ```java
  boolean hasApple = list.contains("Apple"); // false
  ```

#### **(2) `indexOf(Object o)`**

- **作用**：返回元素第一次出现的索引，未找到则返回 -1。

- 示例

  ```java
  int index = list.indexOf("Grape"); // 0
  ```

------

### **6. 清空与判空**

#### **(1) `clear()`**

- **作用**：清空所有元素。

- 示例

  ```java
  list.clear(); // 列表变为 []
  ```

#### **(2) `isEmpty()`**

- **作用**：判断列表是否为空。

- 示例

  ```java
  boolean empty = list.isEmpty(); // true
  ```

------

### **7. 遍历列表**

#### **(1) for 循环**

```java
for (int i = 0; i < list.size(); i++) {
    System.out.println(list.get(i));
}
```

#### **(2) 增强 for 循环（foreach）**

```java
for (String fruit : list) {
    System.out.println(fruit);
}
```

#### **(3) 迭代器（Iterator）**

```java
Iterator<String> it = list.iterator();
while (it.hasNext()) {
    System.out.println(it.next());
}
```

------

### **8. 转换为数组**

#### **(1) `toArray()`**

- **作用**：将列表转为 `Object[]` 数组。

- 示例

  ```java
  Object[] array = list.toArray();
  ```

#### **(2) `toArray(T[] a)`**

- **作用**：转为指定类型的数组。

- 示例

  ```java
  String[] fruitArray = list.toArray(new String[0]);
  ```

------

### **9. 其他实用方法**

#### **(1) `subList(int fromIndex, int toIndex)`**

- **作用**：返回子列表视图（原列表修改会影响子列表）。

- 示例

  ```java
  List<String> subList = list.subList(0, 1); // 包含 fromIndex，不包含 toIndex
  ```

#### **(2) `sort(Comparator<? super E> c)`**

- **作用**：按比较器排序列表。

- 示例

  ```java
  list.sort(Comparator.naturalOrder()); // 自然排序（升序）
  ```

### **LinkedList 常用方法**

`LinkedList` 是 Java 中基于 **双向链表** 实现的列表，适用于频繁插入/删除的场景。以下是其核心方法及使用示例：

------

## **1. 添加元素**

### **(1) `add(E element)`**

- **作用**：在链表末尾添加元素。

- **时间复杂度**：**O(1)**。

- 示例

  ```java
  LinkedList<String> list = new LinkedList<>();
  list.add("Apple");  // ["Apple"]
  list.add("Banana"); // ["Apple", "Banana"]
  ```

### **(2) `addFirst(E element)` / `addLast(E element)`**

- **作用**：在链表头部/尾部插入元素。

- **时间复杂度**：**O(1)**。

- 示例

  ```java
  list.addFirst("Orange"); // ["Orange", "Apple", "Banana"]
  list.addLast("Grape");   // ["Orange", "Apple", "Banana", "Grape"]
  ```

### **(3) `add(int index, E element)`**

- **作用**：在指定位置插入元素。

- **时间复杂度**：**O(n)**（需要遍历到指定位置）。

- 示例

  ```java
  list.add(1, "Peach"); // ["Orange", "Peach", "Apple", "Banana", "Grape"]
  ```

------

## **2. 获取元素**

### **(1) `get(int index)`**

- **作用**：获取指定位置的元素。

- **时间复杂度**：**O(n)**（链表需遍历）。

- 示例

  ```java
  String fruit = list.get(2); // "Apple"
  ```

### **(2) `getFirst()` / `getLast()`**

- **作用**：获取链表头/尾元素。

- **时间复杂度**：**O(1)**。

- 示例

  ```java
  String first = list.getFirst(); // "Orange"
  String last = list.getLast();   // "Grape"
  ```

------

## **3. 删除元素**

### **(1) `remove()` / `removeFirst()` / `removeLast()`**

- **作用**：删除并返回链表头/尾元素。

- **时间复杂度**：**O(1)**。

- 示例

  ```java
  String removedHead = list.remove();      // 删除 "Orange"，返回 "Orange"
  String removedTail = list.removeLast();   // 删除 "Grape"，返回 "Grape"
  ```

### **(2) `remove(int index)`**

- **作用**：删除指定位置的元素。

- **时间复杂度**：**O(n)**。

- 示例

  ```java
  String removed = list.remove(1); // 删除 "Apple"，返回 "Apple"
  ```

### **(3) `remove(Object o)`**

- **作用**：删除第一个匹配的元素（按 `equals()` 判断）。

- **时间复杂度**：**O(n)**。

- 示例

  ```java
  boolean isRemoved = list.remove("Banana"); // true
  ```

------

## **4. 修改元素**

### **(1) `set(int index, E element)`**

- **作用**：修改指定位置的元素。

- **时间复杂度**：**O(n)**。

- 示例

  ```java
  list.set(0, "Mango"); // 将第一个元素改为 "Mango"
  ```

------

## **5. 查找元素**

### **(1) `contains(Object o)`**

- **作用**：判断链表是否包含某元素。

- **时间复杂度**：**O(n)**。

- 示例

  ```java
  boolean hasMango = list.contains("Mango"); // true
  ```

### **(2) `indexOf(Object o)` / `lastIndexOf(Object o)`**

- **作用**：返回元素第一次/最后一次出现的索引。

- 示例

  ```java
  int firstIndex = list.indexOf("Mango"); // 0
  ```

------

## **6. 队列操作（Deque 接口）**

`LinkedList` 实现了 `Deque` 接口，支持队列操作：

### **(1) `offer(E e)` / `offerFirst(E e)` / `offerLast(E e)`**

- **作用**：向队列尾部/头部添加元素（失败返回 `false`）。

- 示例

  ```java
  list.offer("Peach"); // 添加到尾部
  ```

### **(2) `poll()` / `pollFirst()` / `pollLast()`**

- **作用**：移除并返回队列头/尾元素（队列为空时返回 `null`）。

- 示例

  ```java
  String head = list.poll(); // 移除并返回第一个元素
  ```

### **(3) `peek()` / `peekFirst()` / `peekLast()`**

- **作用**：查看队列头/尾元素（不删除）。

- 示例

  ```java
  String first = list.peek(); // 返回第一个元素但不删除
  ```

------

## **7. 遍历 LinkedList**

### **(1) for 循环（不推荐，效率低）**

```java
for (int i = 0; i < list.size(); i++) {
    System.out.println(list.get(i)); // 每次 get(i) 都是 O(n)！
}
```

### **(2) 增强 for 循环（推荐）**

```java
for (String fruit : list) {
    System.out.println(fruit);
}
```

### **(3) 迭代器（Iterator）**

```java
Iterator<String> it = list.iterator();
while (it.hasNext()) {
    System.out.println(it.next());
}
```

------

## **8. 其他方法**

### **(1) `size()`**

- **作用**：返回链表元素个数。

- 示例

  ```java
  int size = list.size(); // 当前元素数量
  ```

### **(2) `clear()`**

- **作用**：清空链表。

- 示例

  ```java
  list.clear(); // 清空所有元素
  ```

### **(3) `toArray()`**

- **作用**：转为数组。

- 示例

  ```java
  Object[] array = list.toArray();
  ```

### **HashSet 常用方法详解**

`HashSet` 是 Java 中基于 `HashMap` 实现的集合类，用于存储 **唯一元素**（不允许重复）。它不保证元素的顺序，但提供高效的查找、插入和删除操作（平均时间复杂度 O(1)）。以下是其核心方法及使用示例：

------

## **1. 添加元素**

### **(1) `add(E element)`**

- **作用**：向集合中添加元素（若元素已存在则忽略）。

- **返回值**：`true`（添加成功）或 `false`（元素已存在）。

- **时间复杂度**：平均 **O(1)**（哈希冲突时可能退化到 O(n)）。

- 示例

  ```java
  HashSet<String> set = new HashSet<>();
  set.add("Apple");  // true
  set.add("Banana"); // true
  set.add("Apple");  // false（重复元素）
  ```

------

## **2. 删除元素**

### **(1) `remove(Object o)`**

- **作用**：删除指定元素（若存在）。

- **返回值**：`true`（删除成功）或 `false`（元素不存在）。

- **时间复杂度**：平均 **O(1)**。

- 示例

  ```java
  set.remove("Banana"); // true
  set.remove("Grape");  // false（元素不存在）
  ```

### **(2) `clear()`**

- **作用**：清空集合中的所有元素。

- 示例

  ```java
  set.clear(); // 集合变为空 []
  ```

------

## **3. 查找元素**

### **(1) `contains(Object o)`**

- **作用**：判断集合是否包含指定元素。

- **返回值**：`true` 或 `false`。

- **时间复杂度**：平均 **O(1)**。

- 示例

  ```java
  boolean hasApple = set.contains("Apple"); // true
  ```

------

## **4. 集合大小与判空**

### **(1) `size()`**

- **作用**：返回集合中的元素数量。

- 示例

  ```java
  int size = set.size(); // 2
  ```

### **(2) `isEmpty()`**

- **作用**：判断集合是否为空。

- 示例

  ```java
  boolean empty = set.isEmpty(); // false
  ```

------

## **5. 遍历 HashSet**

### **(1) 增强 for 循环（推荐）**

```java
for (String fruit : set) {
    System.out.println(fruit);
}
```

### **(2) 迭代器（Iterator）**

```java
Iterator<String> it = set.iterator();
while (it.hasNext()) {
    System.out.println(it.next());
}
```

### **(3) Java 8 forEach**

```java
set.forEach(System.out::println);
```

------

## **6. 转换为数组**

### **(1) `toArray()`**

- **作用**：将集合转为 `Object[]` 数组。

- 示例

  ```java
  Object[] array = set.toArray();
  ```

### **(2) `toArray(T[] a)`**

- **作用**：转为指定类型的数组。

- 示例

  ```java
  String[] fruitArray = set.toArray(new String[0]);
  ```

------

## **7. 集合操作（交集、并集、差集）**

### **(1) `addAll(Collection<? extends E> c)`（并集）**

- **作用**：将另一个集合的所有元素添加到当前集合（自动去重）。

- 示例

  ```java
  HashSet<String> otherSet = new HashSet<>(Arrays.asList("Grape", "Apple"));
  set.addAll(otherSet); // set: ["Apple", "Banana", "Grape"]
  ```

### **(2) `retainAll(Collection<?> c)`（交集）**

- **作用**：仅保留当前集合中与另一集合共有的元素。

- 示例

  ```java
  set.retainAll(Arrays.asList("Apple", "Grape")); // set: ["Apple", "Grape"]
  ```

### **(3) `removeAll(Collection<?> c)`（差集）**

- **作用**：删除当前集合中与另一集合重合的元素。

- 示例

  ```java
  set.removeAll(Arrays.asList("Apple")); // set: ["Grape"]
  ```

------

## **8. 其他注意事项**

1. **允许 `null` 值**：

   ```java
   set.add(null); // 合法
   ```

2. **线程不安全**：

   - 多线程环境下需使用 `Collections.synchronizedSet` 或 `ConcurrentHashMap` 的包装类。

3. **元素唯一性**：

   - 依赖 `hashCode()` 和 `equals()` 方法判断重复性，需确保自定义对象正确重写这两个方法。

### HashMap 常用方法

`HashMap` 是 Java 中最常用的 **键值对（Key-Value）存储结构**，基于哈希表实现，提供高效的查找、插入和删除操作（平均时间复杂度 O(1)）。以下是其核心方法及使用示例：

------

## **1. 添加/更新键值对**

### **(1) `put(K key, V value)`**

- **作用**：添加键值对（若 `key` 已存在则覆盖旧值）。

- **返回值**：被覆盖的旧值（若 `key` 不存在则返回 `null`）。

- **时间复杂度**：平均 **O(1)**（哈希冲突时可能退化到 O(n)）。

- 示例

  ```java
  HashMap<String, Integer> map = new HashMap<>();
  map.put("Apple", 10);   // null（首次添加）
  map.put("Banana", 20);  // null
  map.put("Apple", 30);  // 返回旧值 10，并更新为 30
  ```

### **(2) `putIfAbsent(K key, V value)`**

- **作用**：仅当 `key` 不存在时才插入键值对。

- **返回值**：已存在的值或 `null`。

- 示例

  ```java
  map.putIfAbsent("Banana", 50); // 返回 20（不更新）
  map.putIfAbsent("Grape", 40);  // null（新增）
  ```

------

## **2. 获取值**

### **(1) `get(Object key)`**

- **作用**：根据 `key` 获取对应的 `value`。

- **返回值**：`value` 或 `null`（若 `key` 不存在）。

- **时间复杂度**：平均 **O(1)**。

- 示例

  ```java
  int count = map.get("Apple"); // 30
  Integer val = map.get("Mango"); // null
  ```

### **(2) `getOrDefault(Object key, V defaultValue)`**

- **作用**：安全获取值，若 `key` 不存在则返回默认值。

- 示例

  ```java
  int count = map.getOrDefault("Mango", 0); // 0
  ```

------

## **3. 删除键值对**

### **(1) `remove(Object key)`**

- **作用**：删除指定 `key` 的键值对。

- **返回值**：被删除的 `value` 或 `null`。

- 示例

  ```java
  map.remove("Banana"); // 返回 20
  map.remove("Mango");  // null
  ```

### **(2) `remove(Object key, Object value)`**

- **作用**：仅当 `key` 和 `value` 均匹配时才删除。

- **返回值**：`true`（删除成功）或 `false`。

- 示例

  ```java
  map.remove("Apple", 10); // false（当前 value 是 30）
  map.remove("Apple", 30); // true
  ```

------

## **4. 判断键/值是否存在**

### **(1) `containsKey(Object key)`**

- **作用**：判断是否包含指定 `key`。

- **时间复杂度**：平均 **O(1)**。

- 示例

  ```java
  boolean hasApple = map.containsKey("Apple"); // false（已被删除）
  ```

### **(2) `containsValue(Object value)`**

- **作用**：判断是否包含指定 `value`。

- **时间复杂度**：**O(n)**（需遍历所有值）。

- 示例

  ```java
  boolean has20 = map.containsValue(20); // false
  ```

------

## **5. 遍历 HashMap**

### **(1) 遍历所有键值对（Entry）**

```java
for (Map.Entry<String, Integer> entry : map.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}
```

### **(2) 遍历所有键（Key）**

```java
for (String key : map.keySet()) {
    System.out.println(key);
}
```

### **(3) 遍历所有值（Value）**

```java
for (int value : map.values()) {
    System.out.println(value);
}
```

### **(4) Java 8 forEach**

```java
map.forEach((key, value) -> System.out.println(key + ": " + value));
```

------

## **6. 集合大小与清空**

### **(1) `size()`**

- **作用**：返回键值对数量。

- 示例

  ```java
  int size = map.size(); // 1（当前只有 "Grape": 40）
  ```

### **(2) `clear()`**

- **作用**：清空所有键值对。

- 示例

  ```java
  map.clear(); // 清空后 size() 为 0
  ```

------

## **7. 其他实用方法**

### **(1) `replace(K key, V value)`**

- **作用**：替换 `key` 对应的 `value`（若 `key` 存在）。

- **返回值**：旧值或 `null`。

- 示例

  ```java
  map.replace("Grape", 50); // 返回 40，并更新为 50
  ```

### **(2) `replace(K key, V oldValue, V newValue)`**

- **作用**：仅当 `key` 和 `oldValue` 均匹配时才替换。

- **返回值**：`true`（替换成功）或 `false`。

- 示例

  ```java
  map.replace("Grape", 40, 60); // false（当前 value 是 50）
  ```

### **(3) `compute(K key, BiFunction)`**

- **作用**：动态计算并更新 `value`（适合计数器场景）。

- 示例

  ```java
  map.compute("Grape", (k, v) -> v + 10); // "Grape": 60
  ```

### **Java 多线程编程**

Java 多线程允许程序同时执行多个任务，提高 CPU 利用率和程序响应速度。以下是 Java 多线程的核心概念、实现方式和常见问题解决方案。

------

## **1. 线程的创建方式**

### **(1) 继承 `Thread` 类**

```java
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread running: " + Thread.currentThread().getName());
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start(); // 启动线程
    }
}
```

- 特点：
  - 直接继承 `Thread`，重写 `run()` 方法。
  - 单继承限制（Java 不支持多继承）。

### **(2) 实现 `Runnable` 接口（推荐）**

```java
class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread running: " + Thread.currentThread().getName());
    }
}

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }
}
```

- 优点：
  - 避免单继承限制。
  - 适合资源共享（多个线程可共享同一个 `Runnable` 实例）。

### **(3) 实现 `Callable` 接口（带返回值）**

```java
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "Result from " + Thread.currentThread().getName();
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        FutureTask<String> futureTask = new FutureTask<>(new MyCallable());
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get()); // 阻塞获取返回值
    }
}
```

- 特点：
  - 可返回结果（通过 `FutureTask`）。
  - 可抛出异常。

------

## **2. 线程生命周期**

线程的状态通过 `Thread.State` 枚举表示：

1. **NEW**：线程刚创建，未启动。
2. **RUNNABLE**：正在运行或就绪（等待 CPU 调度）。
3. **BLOCKED**：等待监视器锁（如 `synchronized`）。
4. **WAITING**：无限期等待（如 `wait()`、`join()`）。
5. **TIMED_WAITING**：超时等待（如 `sleep(ms)`）。
6. **TERMINATED**：线程执行完毕。

------

## **3. 线程同步与锁**

### **(1) `synchronized` 关键字**

- 同步方法：

  ```java
  public synchronized void increment() {
      counter++;
  }
  ```

- 同步代码块：

  ```java
  public void increment() {
      synchronized (this) {
          counter++;
      }
  }
  ```

- 特点：

  - 基于 JVM 内置锁（悲观锁）。
  - 保证原子性和可见性。

### **(2) `ReentrantLock`（可重入锁）**

```java
import java.util.concurrent.locks.ReentrantLock;

private final ReentrantLock lock = new ReentrantLock();

public void increment() {
    lock.lock();
    try {
        counter++;
    } finally {
        lock.unlock(); // 必须手动释放
    }
}
```

- 优点：
  - 支持公平锁（`new ReentrantLock(true)`）。
  - 可中断锁（`lockInterruptibly()`）。

### **(3) 原子类（`AtomicInteger` 等）**

```java
import java.util.concurrent.atomic.AtomicInteger;

private AtomicInteger counter = new AtomicInteger(0);

public void increment() {
    counter.incrementAndGet(); // CAS 操作
}
```

- 特点：
  - 无锁实现（基于 CPU 的 CAS 指令）。
  - 高性能（适合简单原子操作）。





## jdk8新特性

### 一、lambda表达式

允许将函数作为方法参数霍代码块进行传递，可以简化匿名内部类，实现函数式编程风格

**语法**：  

```java
(parameters) -> expression
// 或
(parameters) -> { statements; }
```

**示例**：  

```java
// 传统匿名内部类
Runnable r1 = new Runnable() {
    @Override
    public void run() {
        System.out.println("Hello");
    }
};

// Lambda 表达式
Runnable r2 = () -> System.out.println("Hello");
```

**关键点**：

- **类型推断**：编译器自动推断参数类型。
- **变量捕获**：可访问`final`或等效`final`的局部变量。
- **简化集合遍历**：结合`forEach`方法使用。



### 二、函数式接口

仅包含一个抽象方法的接口，可以使用@FunctionInterface

**常见内置接口**：

1. `Predicate<T>`

   条件判断：

   ```
   boolean test(T t)
   ```

   ```java
   Predicate<String> isEmpty = s -> s.isEmpty();
   ```

2. `Consumer<T>`

   消费数据：

   ```
   void accept(T t)
   ```

   ```java
   Consumer<String> print = s -> System.out.println(s);
   ```

3. `Function<T, R>`

   ```
   R apply(T t)
   ```

   ```java
   Function<String, Integer> length = s -> s.length();
   ```

4. `Supplier<T>`

   ```
   T get()
   ```

   ```java
   Supplier<Double> random = () -> Math.random();
   ```

**自定义函数式接口**：

```java
@FunctionalInterface
interface MyFunction {
    int operate(int a, int b);
}

MyFunction add = (a, b) -> a + b;
```

### 三、Stream API

以申明式处理集合数据，支持并行操作，简化复杂数据转换、过滤和聚合。

- 无存储：不修改原始数据源。
- 惰性求值：中间操作（如fliter）延迟执行，终端操作（如collect）触发计算。
- 可并行：通过parallelStream()自动并行处理

**常用操作**：

1. 中间操作

   （返回新Stream）：

   - `filter(Predicate)`：过滤元素。
   - `map(Function)`：元素转换。
   - `sorted()`：排序。

2. 终端操作

   （返回结果或副作用）：

   - `collect(Collectors.toList())`：收集结果。
   - `forEach(Consumer)`：遍历元素。
   - `reduce(BinaryOperator)`：聚合元素。

**示例**：

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
List<Integer> squares = numbers.stream()
    .filter(n -> n % 2 == 0)
    .map(n -> n * n)
    .collect(Collectors.toList()); // 输出 [4, 16]
```

**并行流**：

```java
long count = numbers.parallelStream()
    .filter(n -> n > 3)
    .count();
```

### 四、Optional类

方便处理`null`，避免空指针异常，明确表示可能为空的返回值

核心方法：

- `Optional.ofNullable(T value)`：包装可能为`null`的值。
- `orElse(T defaultValue)`：提供默认值。
- `ifPresent(Consumer)`：值存在时执行操作。
- `orElseThrow()`：值不存在时抛出异常。

**示例**：

```java
Optional<String> name = Optional.ofNullable(getName());
String result = name.orElse("Unknown");

// 链式调用
User user = getUserById(1)
    .orElseThrow(() -> new NotFoundException("User not found"));
```

**注意事项**：

- 避免在字段或方法参数中使用`Optional`。
- 不要滥用`isPresent()`和`get()`，优先使用函数式方法。

### 五、新的日期时间 API（JSR 310）

**背景**：
解决旧`java.util.Date`和`Calendar`的线程安全、设计混乱等问题。

**核心类**：

1. **`LocalDate`**：日期（年月日）。
2. **`LocalTime`**：时间（时分秒）。
3. **`LocalDateTime`**：日期 + 时间。
4. **`ZonedDateTime`**：带时区的日期时间。
5. **`DateTimeFormatter`**：替代`SimpleDateFormat`，线程安全。

**示例**：

java

```java
LocalDate today = LocalDate.now(); 
LocalDate nextWeek = today.plusWeeks(1);

// 格式化
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
String formatted = today.format(formatter);

// 时区处理
ZonedDateTime zonedTime = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
```

**优势**：

- **不可变性**：所有类实例不可变，线程安全。
- **链式调用**：方法如`plusDays()`返回新对象。
- **明确语义**：如`Period`表示日期差，`Duration`表示时间差。
