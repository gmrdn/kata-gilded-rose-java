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
        if (item.name.equals("Aged Brie")
                || item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    increaseQuality(item);

                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
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


        if (item.sellIn < 0) {
            if (item.name.equals("Aged Brie")) {
                increaseQuality(item);
            } else {
                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    item.quality = 0;
                } else {
                    if (item.quality > 0) {
                        decreaseQuality(item);
                    }
                }
            }
        }
    }

    private void decreaseSellin(Item item) {
        if (!isLegendary(item)) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private void decreaseQuality(Item item) {
        if (!isLegendary(item) && item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < HIGHEST_QUALITY) {
            item.quality = item.quality + 1;
        }
    }

    private boolean isLegendary(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }
}