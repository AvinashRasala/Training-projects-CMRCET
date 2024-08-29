package Module_2RestaurantManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<MenuItem> items;

    public Order() {
        items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public void printOrder() {
        for (MenuItem item : items) {
            System.out.println(item);
        }
    }

    public double calculateTotal(BillingStrategy strategy) {
        double total = 0;
        for (MenuItem item : items) {
            total += strategy.calculatePrice(item);
        }
        return total;
    }
}
