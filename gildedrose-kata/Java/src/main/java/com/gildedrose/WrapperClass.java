package com.gildedrose;

public class WrapperClass {
    private Strategy strategy;

    public WrapperClass(Strategy pStrategy) {
        strategy = pStrategy;
    }

    public void updateItemQuality(Item item) {
        strategy.updateItemQuality(item);
    }
}
