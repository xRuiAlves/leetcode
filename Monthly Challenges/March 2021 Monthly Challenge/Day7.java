public class Day7 {
    private class KeyValuePair {
        public final int key;
        public final int value;

        public KeyValuePair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return String.format("%d -> %d", key, value);
        }
    }

    private final KeyValuePair voidedKeyValuePair = new KeyValuePair(-2, -2);
    private static final int SIZE = 50000;
    private final KeyValuePair[] table;

    private int hash(int key) {
        return key % SIZE;
    }

    private int findTableIdx(int key) {
        for (int i = 0; i < SIZE; ++i) {
            KeyValuePair curr = table[hash(key + i)];
            if (curr == null) {
                break;
            }
            if (curr.key == key) {
                return hash(key + i);
            }
        }

        return -1;
    }

    /** Initialize your data structure here. */
    public MyHashMap() {
        this.table = new KeyValuePair[SIZE];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        KeyValuePair kv = new KeyValuePair(key, value);
        
        for (int i = 0; i < SIZE; ++i) {
            if (table[hash(key + i)] == null || table[hash(key + i)].key == key) {
                table[hash(key + i)] = kv;
                break;
            }
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int idx = findTableIdx(key);
        return idx == -1
            ? idx
            : table[idx].value;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int idx = findTableIdx(key);
        if (idx != -1) {
            table[idx] = voidedKeyValuePair;
        }
    }
}
