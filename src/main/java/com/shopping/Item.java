package com.shopping;

public enum Item {
    APPLE("Apple", 35),
    BANANA("Banana", 20),
    MELON("Melon", 50),
    LIME("Lime", 15);

    private final String name;
    private final int price;

    Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

}
