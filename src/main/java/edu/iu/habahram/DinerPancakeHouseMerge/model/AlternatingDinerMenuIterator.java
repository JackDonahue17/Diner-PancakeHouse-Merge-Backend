package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class AlternatingDinerMenuIterator implements Iterator<MenuItem> {
    MenuItem[] items;
    int position;
    boolean isEven;
    List<MenuItem> evenDayItems;
    List<MenuItem> oddDayItems;

    public AlternatingDinerMenuIterator(MenuItem[] items) {
        this.items = items;
        position = 0;
        Calendar date = Calendar.getInstance();
        int day_of_week = date.get(Calendar.DAY_OF_WEEK);
        isEven = (day_of_week % 2 == 0);

        for (MenuItem item : items) {
            if (item != null) {
                if (item.isVegetarian()) {
                    evenDayItems.add(item);
                } else {
                    oddDayItems.add(item);
                }
            }
        }
    }

    public MenuItem next() {
        MenuItem menuItem;
        if (isEven) {
            menuItem = evenDayItems.get(position);
        } else {
            menuItem = oddDayItems.get(position);
        }
        position++;
        return menuItem;
    }

    public boolean hasNext() {
        if (position >= items.length || items[position] == null) {
            return false;
        } else {
            return true;
        }
    }
}
