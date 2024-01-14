package temp.solid.domain;

public class NotificationService {
    public void sentNotification(Order order) {
        String supplier = order.getSupplier();
        if(supplier != null && !supplier.isBlank()){
            sendEmail(supplier);
        }
    }

    private void sendEmail(String supplier) {
    }
}
