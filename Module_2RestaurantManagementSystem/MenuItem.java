package Module_2RestaurantManagementSystem;

// Abstract base class for menu items
public abstract class MenuItem {
    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void display() {
        System.out.println(name + ": $" + price);
    }

    @Override
    public String toString() {
        return name + ": $" + price;
    }
}
