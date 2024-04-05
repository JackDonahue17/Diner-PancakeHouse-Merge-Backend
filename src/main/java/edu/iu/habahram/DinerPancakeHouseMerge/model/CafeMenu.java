package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CafeMenu extends Menu {

    static final int MAX_ITEMS = 6;
    int numberOfItems = 0;
    MenuItem[] menuItems;
    public CafeMenu(String name, String description) {
        super(name, description);

        addItem("Veggie Burger and Air Fries",
                "Veggie burger on a whole wheat bun, lettuce, tomato, and fries",
                true, 3.99);
        addItem("Soup of the day",
                "A cup of the soup of the day, with a side salad",
                false, 3.69);
        addItem("Burrito",
                "A large burrito, with whole pinto beans, salsa, guacamole",
                true, 4.29);
    }

    public void addItem(String name, String description,
                        boolean vegetarian, double price)
    {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        add(menuItem);
    }

    public MenuItem[] getMenuItems() {
        return menuItems;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(MenuItem item: getMenuItems()) {
            stringBuilder.append(item.toString());
        }
        return  stringBuilder.toString();
    }

    /*@Override
    public Iterator<MenuItem> createIterator() {
        return new CafeMenuIterator(getMenuItems());
    }*/
}