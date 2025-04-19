package day02.homework;

public class interface_homework {
    /*
    定义一个接口Vehicle，其中包括一个默认方法honk，然后在接口的实现类中调用这个默认方法。
     */



    public static void main(String[] args) {
        Vehicle car = new Car();
        car.honk();
    }
}

interface Vehicle {
    default void honk(){
        System.out.println("喇叭");
    }
}

class Car implements Vehicle{
    void drive(){}
}
