package com.shopping;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingBasketCalculatorIntegrationTest {

    private ShoppingBasketCalculator basketCalculator;

    @BeforeEach
    public void setUp() {

        // Create the calculator
        basketCalculator = new ShoppingBasketCalculator();
    }

    @Test
    public void testCalculateTotalCostWithAddedAndRemovedItems() {
        // Add items to the basket
        basketCalculator.addItemToBasket(Item.APPLE);
        basketCalculator.addItemToBasket(Item.APPLE);
        basketCalculator.addItemToBasket(Item.BANANA);
        basketCalculator.addItemToBasket(Item.MELON);
        basketCalculator.addItemToBasket(Item.MELON);
        basketCalculator.addItemToBasket(Item.LIME);
        basketCalculator.addItemToBasket(Item.LIME);
        basketCalculator.addItemToBasket(Item.LIME);

        // Calculate and verify the total cost
        long totalCost = basketCalculator.calculateTotalCost();
        assertEquals(35 + 35 + 20 + 50 + 50 + 15 + 15 + 15, totalCost);

        // Remove items from the basket
        basketCalculator.removeItemFromBasket(Item.APPLE);
        basketCalculator.removeItemFromBasket(Item.LIME);
        basketCalculator.removeItemFromBasket(Item.LIME);

        // Calculate and verify the total cost after removal
        totalCost = basketCalculator.calculateTotalCost();
        assertEquals(35 + 35 + 20 + 50 + 50 + 15 + 15 + 15 - 35 - 15 - 15, totalCost);
    }
}

