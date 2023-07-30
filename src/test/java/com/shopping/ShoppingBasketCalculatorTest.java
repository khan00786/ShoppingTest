package com.shopping;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingBasketCalculatorTest {


    private final Map<String, Integer> itemPrices = new HashMap<>();
    private ShoppingBasketCalculator basketCalculator;

    @BeforeEach
    public void setUp() {
        basketCalculator = new ShoppingBasketCalculator();
    }

    @Test
    public void testEmptyBasket() {
        long totalCost = basketCalculator.calculateTotalCost();
        assertEquals(0, totalCost);
    }

    @Test
    public void testAddedItemsToBasket() {
        basketCalculator.addItemToBasket(Item.APPLE);
        basketCalculator.addItemToBasket(Item.APPLE);
        basketCalculator.addItemToBasket(Item.BANANA);
        basketCalculator.addItemToBasket(Item.MELON);
        basketCalculator.addItemToBasket(Item.MELON);
        basketCalculator.addItemToBasket(Item.LIME);
        basketCalculator.addItemToBasket(Item.LIME);
        basketCalculator.addItemToBasket(Item.LIME);

        long totalCost = basketCalculator.calculateTotalCost();
        assertEquals(35 + 35 + 20 + 50 + 50 + 15 + 15 + 15, totalCost);
    }

    @Test
    public void testRemoveItemFromBasket() {
        basketCalculator.addItemToBasket(Item.APPLE);
        basketCalculator.addItemToBasket(Item.BANANA);
        basketCalculator.addItemToBasket(Item.APPLE);
        basketCalculator.removeItemFromBasket(Item.APPLE);

        long totalCost = basketCalculator.calculateTotalCost();
        assertEquals(35 + 20 + 35 - 35, totalCost);
    }

    @Test
    public void testRemoveNonExistingItemFromBasket() {
        basketCalculator.addItemToBasket(Item.APPLE);
        basketCalculator.addItemToBasket(Item.BANANA);
        basketCalculator.removeItemFromBasket(Item.MELON); // Melon is not in the basket

        long totalCost = basketCalculator.calculateTotalCost();
        assertEquals(35 + 20 - 0, totalCost);
    }

    @Test
    public void testAddAndRemoveItemsFromBasket() {
        basketCalculator.addItemToBasket(Item.APPLE);
        basketCalculator.addItemToBasket(Item.BANANA);
        basketCalculator.addItemToBasket(Item.APPLE);
        basketCalculator.addItemToBasket(Item.MELON);
        basketCalculator.removeItemFromBasket(Item.APPLE);
        basketCalculator.addItemToBasket(Item.LIME);
        basketCalculator.addItemToBasket(Item.LIME);
        basketCalculator.removeItemFromBasket(Item.LIME);
        basketCalculator.addItemToBasket(Item.LIME);
        long totalCost = basketCalculator.calculateTotalCost();
        assertEquals(35 + 20 + 35 + 50 - 35 + 15 + 15 - 15 + 15, totalCost);
    }
}
