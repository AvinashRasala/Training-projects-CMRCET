package Module_2RestaurantManagementSystem;

// BillingStrategy interface
public interface BillingStrategy {
    double calculatePrice(MenuItem item);
}

// StandardBillingStrategy class
class StandardBillingStrategy implements BillingStrategy {
    @Override
    public double calculatePrice(MenuItem item) {
        return item.getPrice();
    }
}

// DiscountBillingStrategy class
class DiscountBillingStrategy implements BillingStrategy {
    private double discount;

    public DiscountBillingStrategy(double discount) {
        this.discount = discount;
    }

    @Override
    public double calculatePrice(MenuItem item) {
        return item.getPrice() - discount;
    }
}
