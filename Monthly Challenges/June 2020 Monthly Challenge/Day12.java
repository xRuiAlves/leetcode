import java.util.ArrayList;
import java.util.HashMap;

public class Day12 {
    HashMap<Integer, Integer> map;
    ArrayList<Integer> elems;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        elems = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }

        elems.add(val);
        map.put(val, elems.size() - 1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        int idx = map.getOrDefault(val, -1);
        if (idx == -1) {
            return false;
        }

        int last_idx = elems.size() - 1;
        int last_val = elems.get(last_idx);
        elems.set(last_idx, val);
        elems.set(idx, last_val);

        elems.remove(last_idx);
        map.remove(val);
        if (last_val != val) {
            map.put(last_val, idx);
        }
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int random_idx = (int)(Math.random() * elems.size());
        return elems.get(random_idx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
