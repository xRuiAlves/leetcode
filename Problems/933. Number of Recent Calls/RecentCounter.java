import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {
    private static final int RECENT_INTERVAL = 3000;
    private final Queue<Integer> recent;

    public RecentCounter() {
        recent = new LinkedList<>();
    }

    public int ping(int t) {
        recent.offer(t);
        int lb = t - RECENT_INTERVAL;
        
        while (recent.peek() < lb) {
            recent.poll();
        }
        
        return recent.size();
    }
}
