package com.shopping;

import java.util.HashMap;
import java.util.Map;

public class ShoppingBasketCalculator {

    private final Map<Item, Integer> itemCounts;

    public ShoppingBasketCalculator() {
        this.itemCounts = new HashMap<>();
    }

    public void addItemToBasket(Item item) {
        itemCounts.merge(item, 1, (existingCount, newCount) -> existingCount + newCount);
    }

    public void removeItemFromBasket(Item item) {
        itemCounts.computeIfPresent(item, (key, count) -> count - 1);
        itemCounts.remove(item, 0); // Remove the item if the count becomes zero
    }

    public long calculateTotalCost() {
        long totalCost = 0;

        for (Map.Entry<Item, Integer> entry : itemCounts.entrySet()) {
            Item item = entry.getKey();
            int count = entry.getValue();
            int price = item.getPrice();
            totalCost += count * price;
        }

        return totalCost;
    }
}
