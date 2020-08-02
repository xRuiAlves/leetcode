import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class MyHashSet {
    private static final int BASE_DATA_SIZE = 100;
    private List<List<Integer>> data;
    private int size;

    public MyHashSet() {
        this.data = new ArrayList<>(BASE_DATA_SIZE);
        this.size = 0;

        for (int i = 0; i < BASE_DATA_SIZE; ++i) {
            this.data.add(new LinkedList<>());
        }
    }

    public void add(int key) {
        List<Integer> row = data.get(key % data.size());

        if (getIndex(row, key) == -1) {
            row.add(key);
            ++this.size;
        }
    }

    public void remove(int key) {
        List<Integer> row = data.get(key % data.size());
        int idx = getIndex(row, key);
        if (idx != -1) {
            row.remove(idx);
        }
    }

    public boolean contains(int key) {
        List<Integer> row = data.get(key % data.size());
        return getIndex(row, key) != -1;
    }

    private int getIndex(List<Integer> row, int key) {
        for (int i = 0; i < row.size(); ++i) {
            if (row.get(i) == key) {
                return  i;
            }
        }
        return -1;
    }
}
