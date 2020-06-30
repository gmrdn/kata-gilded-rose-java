package com.gildedrose;

class GildedRose {
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

        if (isImprovingOverTime(item)) appropriateStrategy = new ConcreteStrategyImprovingItem();
        else if (isImprovingUntilExpiration(item)) appropriateStrategy = new ConcreteStrategyImprovingItemUntilExpiration();
        else if (isConjuredI(item)) appropriateStrategy = new ConcreteStrategyConjuredItem();
        //else if (isImprovingUntilExpiration(item)) appropriateStrategy = new ConcreteStrategyImprovingItemUntilExpiration();
        else appropriateStrategy = new ConcreteStrategyStandardItem();

        WrapperClass wrappedItem = new WrapperClass(appropriateStrategy);
        wrappedItem.updateItemQuality(item);
    }

    private boolean isImprovingUntilExpiration(Item item) {
        return nameMatches(item, "Backstage passes");
    }

    private boolean isImprovingOverTime(Item item) {
        return nameMatches(item, "Aged Brie");
    }

    private boolean isConjuredI(Item item) {
        return nameMatches(item, "Conjured");
    }

    private boolean isLegendary(Item item) {
        return nameMatches(item, "Sulfuras, Hand of Ragnaros");
    }


    private boolean nameMatches(Item item, String s) {
        return item.name.contains(s);
    }

}