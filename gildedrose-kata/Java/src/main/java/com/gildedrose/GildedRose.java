package com.gildedrose;

class GildedRose {
    public static final int HIGHEST_QUALITY = 50;
    public static final int DEGRADATION_FACTOR_CONJURED_ITEM = 2;
    public static final int DEGRADATION_FACTOR_NORMAL_ITEM = 1;
    public static final int DEGRADATION_FACTOR_NIL = 0;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }
    
    public void updateQuality() {
        for (Item item : items) {
            updateItemQuality(item);
        }
    }

    private void updateItemQuality(Item item) {

        if (itemImprovingOverTime(item)) {
            increaseQuality(item);
        }
        else if (itemImprovingUntilExpiration(item)) {
            increaseQuality(item);
            if (itemImprovingUntilExpiration(item)) {
                if (item.sellIn < 11) {
                    increaseQuality(item);
                }
                if (item.sellIn < 6) {
                    increaseQuality(item);
                }
            }
        } else {
            decreaseQuality(item);
        }

        decreaseSellIn(item);

        if (passedSellIn(item)) {
            if (itemImprovingOverTime(item)) {
                increaseQuality(item);
            } else {
                if (itemImprovingUntilExpiration(item)) {
                    item.quality = 0;
                } else {
                    decreaseQuality(item);
                }
            }
        }
    }

    private boolean itemImprovingUntilExpiration(Item item) {
        return nameMatches(item, "Backstage passes");
    }

    private boolean itemImprovingOverTime(Item item) {
        return nameMatches(item, "Aged Brie");
    }

    private boolean nameMatches(Item item, String s) {
        return item.name.contains(s);
    }

    private boolean passedSellIn(Item item) {
        return item.sellIn < 0;
    }

    private void decreaseSellIn(Item item) {
        if (isNotLegendary(item)) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private void decreaseQuality(Item item) {
        item.quality -= getDegradationFactor(item);
    }

    private int getDegradationFactor(Item item) {
        if (isNotLegendary(item) && item.quality > 0) {
            if (isConjured(item) && item.quality > 1) {
                return DEGRADATION_FACTOR_CONJURED_ITEM;
            }
            return DEGRADATION_FACTOR_NORMAL_ITEM;
        }
        return DEGRADATION_FACTOR_NIL;
    }

    private boolean isConjured(Item item) {
        return nameMatches(item, "Conjured");
    }

    private void increaseQuality(Item item) {
        if (item.quality < HIGHEST_QUALITY) {
            item.quality = item.quality + 1;
        }
    }

    private boolean isNotLegendary(Item item) {
        return !nameMatches(item, "Sulfuras, Hand of Ragnaros");
    }
}