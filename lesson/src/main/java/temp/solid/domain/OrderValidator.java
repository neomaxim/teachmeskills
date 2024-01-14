package temp.solid.domain;

import java.util.List;

public class OrderValidator {
   public boolean isValid(Order order) {
       List<Product> products = order.getProducts();
       if (products == null || products.isEmpty()) {
           return false;
       }
       for (Product product : products) {
           if (product.getId() == null || product.getPrice() == null) {
               return false;
           }
       }
       return true;
   }
}
