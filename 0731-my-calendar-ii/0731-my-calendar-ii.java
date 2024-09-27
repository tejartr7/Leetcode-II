import java.util.TreeMap;

class MyCalendarTwo {
    private TreeMap<Integer, Integer> map; // Key: time, Value: +1 for start, -1 for end

    public MyCalendarTwo() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        // Increment the start time
        map.put(start, map.getOrDefault(start, 0) + 1);
        // Decrement the end time
        map.put(end, map.getOrDefault(end, 0) - 1);

        int ongoing = 0; // Count of ongoing events
        for (int count : map.values()) {
            ongoing += count;
            // If ongoing events exceed 2, it's an invalid booking
            if (ongoing > 2) {
                // Rollback the changes
                map.put(start, map.get(start) - 1);
                map.put(end, map.get(end) + 1);
                
                // Remove entries if the count becomes zero
                if (map.get(start) == 0) {
                    map.remove(start);
                }
                if (map.get(end) == 0) {
                    map.remove(end);
                }
                
                return false; // Booking fails
            }
        }
        return true; // Booking successful
    }
}
