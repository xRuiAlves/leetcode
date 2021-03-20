import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    private static final class Event {
        public final int id;
        public final String stationName;
        public final int t;

        public Event(int id, String stationName, int t) {
            this.id = id;
            this.stationName = stationName;
            this.t = t;
        }
    }

    private static final char NAME_SEPARATOR = '_';

    private final Map<Integer, Event> checkInEvents;
    private final Map<String, List<Integer>> trips;

    public UndergroundSystem() {
        checkInEvents = new HashMap<>();
        trips = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInEvents.put(id, new Event(id, stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Event checkInEvent = checkInEvents.get(id);
        String tripIdentifier = getTripIdentifier(checkInEvent.stationName, stationName);
        int duration = t - checkInEvent.t;
        
        List<Integer> tripDurations = trips.getOrDefault(tripIdentifier, new LinkedList<>());
        tripDurations.add(duration);
        trips.put(tripIdentifier, tripDurations);
    }

    public double getAverageTime(String startStation, String endStation) {
        String tripIdentifier = getTripIdentifier(startStation, endStation);
        return trips
            .get(tripIdentifier)
            .stream()
            .mapToDouble(duration -> duration)
            .average()
            .getAsDouble();
    }

    private static String getTripIdentifier(String startStation, String endStation) {
        return String.format("%s%c%s", startStation, NAME_SEPARATOR, endStation);
    }
}
