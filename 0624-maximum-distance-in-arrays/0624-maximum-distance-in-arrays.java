import java.util.*;

class Pair implements Comparable<Pair> {
    int value, index;

    Pair(int value, int index) {
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(Pair other) {
        return this.value - other.value;
    }
}

class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int m = arrays.size();
        List<Pair> list = new ArrayList<>();
        
        // Create pairs of (value, index) for the first and last element of each array
        for (int i = 0; i < m; i++) {
            list.add(new Pair(arrays.get(i).get(0), i));
            list.add(new Pair(arrays.get(i).get(arrays.get(i).size() - 1), i));
        }
        
        // Sort the list based on the value
        Collections.sort(list);
        
        // The two possible max differences considering different arrays
        int maxDistance = Integer.MIN_VALUE;
        
        // Check difference between the largest and smallest element with different indices
        if (list.get(0).index != list.get(2 * m - 1).index) {
            maxDistance = list.get(2 * m - 1).value - list.get(0).value;
        } else {
            // If they are from the same array, check other combinations
            int option1 = list.get(2 * m - 2).value - list.get(0).value; // second largest and smallest
            int option2 = list.get(2 * m - 1).value - list.get(1).value; // largest and second smallest
            maxDistance = Math.max(option1, option2);
        }
        
        return maxDistance;
    }
}