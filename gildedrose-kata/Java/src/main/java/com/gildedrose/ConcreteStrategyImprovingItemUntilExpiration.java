package com.gildedrose;

public class ConcreteStrategyImprovingItemUntilExpiration implements Strategy {
    public static final int HIGHEST_QUALITY = 50;


    public void updateItemQuality(Item item) {
        increaseQuality(item);
        if (item.sellIn < 11) {
            increaseQuality(item);
        }
        if (item.sellIn < 6) {
            increaseQuality(item);
        }
        decreaseSellIn(item);
        if (passedSellIn(item)) {
            item.quality = 0;
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
