package temp.solid;

import temp.solid.domain.NotificationService;
import temp.solid.domain.Order;
import temp.solid.domain.OrderStorage;
import temp.solid.domain.OrderValidator;

public class OrderService {
    private OrderValidator validator = new OrderValidator();
    private OrderStorage storage = new OrderStorage();
    private NotificationService notificationService = new NotificationService();
    public  void process(Order order){
        System.out.printf("process(order=>" + order +")");
        if(!validator.isValid(order) ) {
            System.out.printf("failed processing (order=>" + order + ")");
        }
            storage.save(order);
            notificationService.sentNotification(order);
        System.out.printf("sucess processing (order=>" + order +")");

        }
    }







