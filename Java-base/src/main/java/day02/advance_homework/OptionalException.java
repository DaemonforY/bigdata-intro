package advance_homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalException {
    /*
    Optional与异常处理结合
    作业描述：编写一个简单的订单处理系统，其中包括以下功能：
    验证输入订单是否存在，不存在则输出警告。
    对存在的订单，检查是否已支付，未支付则抛出自定义异常。
    计算订单总金额，并使用Optional包装返回。
    要求：结合使用Optional的ifPresent、orElseThrow等方法，设计一个自定义异常类。
     */

    static class UnpaidOrderException extends Exception {
        public UnpaidOrderException(String message) {
            super(message);
        }
    }

    static class Order {
        private String id;
        private double money;
        private boolean paid;

        public Order(String id, double money, boolean paid) {
            this.id = id;
            this.money = money;
            this.paid = paid;
        }

        public String getId() {
            return id;
        }

        public boolean isPaid() {
            return paid;
        }

        public double getMoney() {
            return money;
        }
    }

    static class OrderSystem {
        private Map<String, Order> orders;

        public OrderSystem() {
            orders = new HashMap<String, Order>();
            orders.put("A", new Order("A", 100.0, false));
            orders.put("B", new Order("B", 200.0, true));
            orders.put("C", new Order("C", 300.0, false));
        }

        public Optional<Order> getOrder(String id) {
            return Optional.ofNullable(orders.get(id));
        }

        public void checkOrder(Order order) throws UnpaidOrderException {
            if (!order.isPaid()) {
                throw new UnpaidOrderException("订单未支付: " + order.getId());
            }
        }

        public Optional<Double> calculateOrderTotal(String id) {
            try {
                Order order = getOrder(id)
                        .orElseThrow(() -> new IllegalArgumentException("订单不存在: " + id));

                checkOrder(order);

                return Optional.of(order.getMoney());
            } catch (UnpaidOrderException e) {
                System.err.println(e.getMessage());
                return Optional.empty();
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
                return Optional.empty();
            }
        }
    }

    public static void main(String[] args) {
        OrderSystem system = new OrderSystem();
        system.calculateOrderTotal("A")
                .ifPresent(System.out::println);

        system.calculateOrderTotal("B")
                .ifPresent(System.out::println);

        system.calculateOrderTotal("C")
                .ifPresent(System.out::println);

        system.calculateOrderTotal("D")
                .ifPresent(System.out::println);
    }
}