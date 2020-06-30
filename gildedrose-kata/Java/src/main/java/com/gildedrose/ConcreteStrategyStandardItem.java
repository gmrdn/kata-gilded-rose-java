package com.gildedrose;

public class ConcreteStrategyStandardItem implements Strategy {

    public void updateItemQuality(Item item) {
        decreaseQuality(item);
        decreaseSellIn(item);
        if (passedSellIn(item)) {
            decreaseQuality(item);
        }
    }

    private boolean passedSellIn(Item item) {
        return item.sellIn < 0;
    }

    private void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private void decreaseQuality(Item item) {
        item.quality -= getDegradationFactor(item);
    }

    private int getDegradationFactor(Item item) {
        if (item.quality > 0) {
            return 1;
        }
        return 0;
    }
}
