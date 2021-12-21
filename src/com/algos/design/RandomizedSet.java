package com.algos.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {

    Map<Integer, Integer> randomizedSet;
    List<Integer> elements;
    Random random;

    public RandomizedSet() {
        randomizedSet = new HashMap<>();
        elements = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if(randomizedSet.containsKey(val)) {
            return false;
        }
        int index = elements.size();
        elements.add(index, val);
        randomizedSet.put(val, index);
        return true;
    }

    public boolean remove(int val) {
        if(randomizedSet.containsKey(val)) {
            int index = randomizedSet.get(val);
            randomizedSet.remove(val);
            if(index == elements.size()-1) {
                elements.remove(index);
            }else {
                int last = elements.get(elements.size()-1);
                elements.set(index, last);
                elements.remove(elements.size()-1);
                randomizedSet.put(last, index);
            }
           return true;
        }
        return false;
    }

    public int getRandom() {
        return elements.get(random.nextInt(elements.size()));
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
        randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
        randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
        randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
        randomizedSet.insert(2); // 2 was already in the set, so return false.
        randomizedSet.getRandom(); // Since
    }
}
