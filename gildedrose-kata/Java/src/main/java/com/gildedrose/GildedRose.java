package com.gildedrose;

class GildedRose {
    public static final int HIGHEST_QUALITY = 50;
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
        if (nameMatches(item, "Aged Brie")
                || nameMatches(item, "Backstage passes to a TAFKAL80ETC concert")) {
                    increaseQuality(item);

                    if (nameMatches(item, "Backstage passes to a TAFKAL80ETC concert")) {
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

        decreaseSellin(item);

        if (passedSellIn(item)) {
            if (nameMatches(item, "Aged Brie")) {
                increaseQuality(item);
            } else {
                if (nameMatches(item, "Backstage passes to a TAFKAL80ETC concert")) {
                    item.quality = 0;
                } else {
                    decreaseQuality(item);
                }
            }
        }
    }

    private boolean nameMatches(Item item, String s) {
        return item.name.contains(s);
    }

    private boolean passedSellIn(Item item) {
        return item.sellIn < 0;
    }

    private void decreaseSellin(Item item) {
        if (isNotLegendary(item)) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private void decreaseQuality(Item item) {
        if (isNotLegendary(item) && item.quality > 0) {
            if (nameMatches(item, "Conjured")) {
                item.quality = item.quality - 2;
            } else {
                item.quality = item.quality - 1;
            }
        }
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