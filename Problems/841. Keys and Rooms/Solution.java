import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms.size() < 2) {
            return true;
        }
        
        boolean[] visited = new boolean[rooms.size()];
        int num_visited = 0;
        Queue<Integer> to_visit = new LinkedList<>();
        to_visit.offer(0);

        while (!to_visit.isEmpty()) {
            int curr = to_visit.poll();
            
            if (visited[curr]) {
                continue;
            }
            
            visited[curr] = true;
            ++num_visited;
            
            to_visit.addAll(rooms.get(curr));
        }
        
        return num_visited == rooms.size();
    }
}
