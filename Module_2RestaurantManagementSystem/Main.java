package Module_2RestaurantManagementSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a restaurant
        Restaurant myRestaurant = new Restaurant();

        // Input restaurant name
        System.out.print("Enter restaurant name: ");
        String restaurantName = scanner.nextLine();
        myRestaurant.setName(restaurantName);
        System.out.println("Restaurant Name: " + myRestaurant.getName());

        // Add menu items to the restaurant
        System.out.println("\nEnter menu items (type 'done' to finish):");

        while (true) {
            System.out.print("Enter item type (Dish/Drink): ");
            String itemType = scanner.nextLine();
            if (itemType.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Enter item name: ");
            String itemName = scanner.nextLine();

            System.out.print("Enter item price: ");
            double itemPrice = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            MenuItem menuItem;
            if (itemType.equalsIgnoreCase("Dish")) {
                menuItem = new Dish(itemName, itemPrice);
            } else if (itemType.equalsIgnoreCase("Drink")) {
                menuItem = new Drink(itemName, itemPrice);
            } else {
                System.out.println("Invalid item type. Please enter 'Dish' or 'Drink'.");
                continue;
            }

            myRestaurant.addMenuItem(menuItem);
            System.out.println("Menu item added.");
        }

        // Print the restaurant's menu
        System.out.println("\nRestaurant Menu:");
        myRestaurant.printMenu();

        // Create a new order
        Order order = new Order();

        System.out.println("\nEnter order items (type 'done' to finish):");

        while (true) {
            System.out.print("Enter item name to order: ");
            String orderItemName = scanner.nextLine();
            if (orderItemName.equalsIgnoreCase("done")) {
                break;
            }

            MenuItem orderedItem = myRestaurant.findMenuItemByName(orderItemName);
            if (orderedItem != null) {
                order.addItem(orderedItem);
                System.out.println("Item added to order.");
            } else {
                System.out.println("Item not found in menu.");
            }
        }

        // Print the order
        System.out.println("\nOrder Details:");
        order.printOrder();

        // Calculate the total with the standard billing strategy
        BillingStrategy standardStrategy = new StandardBillingStrategy();
        double totalStandard = order.calculateTotal(standardStrategy);
        System.out.println("\nTotal (Standard Billing): $" + totalStandard);

        // Calculate the total with a discount billing strategy
        System.out.print("Enter discount amount: ");
        double discountAmount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        BillingStrategy discountStrategy = new DiscountBillingStrategy(discountAmount);
        double totalDiscount = order.calculateTotal(discountStrategy);
        System.out.println("Total (Discount Billing): $" + totalDiscount);

        scanner.close();
    }
}
