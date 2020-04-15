package Lesson5;

import java.util.ArrayList;
import java.util.List;

public class Backpack {

    public int count = 0;
    private int maxWeight;
    private int maxPrice;
    private List<Thing> bestItems = null;

    public Backpack(int maxWeight) {
        this.maxWeight = maxWeight;
    }


    private int calcWeight(List<Thing> items) {
        int sumWeight = 0;
        for (Thing item : items) {
            sumWeight += item.weight;
        }
        return sumWeight;
    }

    private int calcPrice(List<Thing> items) {
        int sumPrice = 0;
        for (Thing item : items) {
            sumPrice += item.price;
        }
        return sumPrice;
    }

    private void bestSet(List<Thing> items) {
        if (bestItems == null) {
            if (calcWeight(items) <= maxWeight) {
                bestItems = items;
                maxPrice = calcPrice(items);
            }
        } else {
            if (calcWeight(items) <= maxWeight && calcPrice(items) > maxPrice) {
                bestItems = items;
                maxPrice = calcPrice(items);
            }
        }
    }

    public void calcBestSet(List<Thing> items) {
        if (items.size() > 0) {
            bestSet(items);
            count++;
        }
        for (int i = 0; i < items.size(); i++) {
            List<Thing> list = new ArrayList<>(items);
            list.remove(i);
            calcBestSet(list);
        }
    }

    public List<Thing> getBestSet() {
        return bestItems;
    }
}
