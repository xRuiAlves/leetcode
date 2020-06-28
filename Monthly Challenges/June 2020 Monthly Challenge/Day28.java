import java.util.*;

public class Day28 {
    private static final String STARTING_PLACE = "JFK";

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> trips = new HashMap<>();

        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            PriorityQueue<String> target_places = trips.getOrDefault(from, new PriorityQueue<>());
            target_places.add(to);
            trips.put(from, target_places);
        }

        List<String> itinerary = new LinkedList<>();
        Stack<String> to_visit = new Stack<>();
        to_visit.push(STARTING_PLACE);

        while (!to_visit.empty()) {
            while (true) {
                PriorityQueue<String> target_places = trips.getOrDefault(to_visit.peek(), null);

                if (target_places == null || target_places.isEmpty()) {
                    break;
                }

                to_visit.push(trips.get(to_visit.peek()).poll());
            }

            itinerary.add(to_visit.pop());
        }

        Collections.reverse(itinerary);
        return itinerary;
    }
}
