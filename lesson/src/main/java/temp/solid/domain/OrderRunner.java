package temp.solid.domain;

import temp.solid.OrderService;

import java.math.BigDecimal;

public class OrderRunner {
    private static final OrderService ORDER_SERVICE = new OrderService();
    public static void main(String[] args) {

        Order order = new Order();
        order.add(new Product(1L,"milk",new BigDecimal(100)));
        order.add(new Product(2L,"Bread",new BigDecimal(50)));
        order.add(new Product(3L,"Cheese",new BigDecimal(500)));
        order.add(new Product(4L,"Meat",new BigDecimal(1000)));
        ORDER_SERVICE.process(order);
    }
}
