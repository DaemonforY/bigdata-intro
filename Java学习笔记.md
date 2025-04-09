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

``` java
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

