package Module_2RestaurantManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private List<MenuItem> menu;

    public Restaurant() {
        menu = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addMenuItem(MenuItem item) {
        menu.add(item);
    }

    public MenuItem findMenuItemByName(String name) {
        for (MenuItem item : menu) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    public void printMenu() {
        for (MenuItem item : menu) {
            System.out.println(item);
        }
    }
}
