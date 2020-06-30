package com.gildedrose;

public class ConcreteStrategyImprovingItem implements Strategy {
    public static final int HIGHEST_QUALITY = 50;

    public void updateItemQuality(Item item) {
        increaseQuality(item);
        decreaseSellIn(item);
        if (passedSellIn(item)) {
            increaseQuality(item);
        }
    }

    private boolean passedSellIn(Item item) {
        return item.sellIn < 0;
    }

    private void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private void increaseQuality(Item item) {
        if (item.quality < HIGHEST_QUALITY) {
            item.quality = item.quality + 1;
        }
    }

}
