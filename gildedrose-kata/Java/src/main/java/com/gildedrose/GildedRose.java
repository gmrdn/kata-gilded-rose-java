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
        Strategy appropriateStrategy;

        if (nameMatches(item, "Aged Brie")) appropriateStrategy = new ConcreteStrategyImprovingItem();
        else appropriateStrategy = new ConcreteStrategyStandardItem();

        WrapperClass wrappedItem = new WrapperClass(appropriateStrategy);
        wrappedItem.updateItemQuality(item);
    }


    private boolean nameMatches(Item item, String s) {
        return item.name.contains(s);
    }

}