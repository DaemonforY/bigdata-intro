package advance_homework;

public class interface_design {
    /*
    接口默认方法扩展与应用
    作业描述：设计一个库存管理接口Inventory，要求包括以下功能：
    一个默认方法showInventory，用来显示当前库存情况。
    一个静态方法calcTotalValue，计算库存商品总价值。
    子接口ElectronicInventory与GroceryInventory，继承Inventory并扩展各自特有的方法。
    要求：实现接口的一个或多个子类，并演示这些扩展功能。
     */

    public static void main(String[] args) {
        Store store = new Store();
        store.showInventory();
        store.showElectronicInventory();

        System.out.println("总价值: " + Inventory.calTotalValue(10, 5.5));
    }
}

interface Inventory{
    default void showInventory(){
        System.out.println("Inventory");
    }

    static double calTotalValue(int num, double price){
        return num * price;
    }
}

interface ElectronicInventory extends Inventory{
    default void showElectronicInventory(){
        System.out.println("Electronic");
    }
}

class Store implements ElectronicInventory{

}