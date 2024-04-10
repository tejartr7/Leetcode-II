class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int N = deck.length;
        Queue<Integer> queue = new LinkedList<>();

        // Create a queue of indexes
        for (int i = 0; i < N; i++) {
            queue.add(i);
        }
        
        Arrays.sort(deck);

        // Put cards at correct index in result
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            // Reveal Card and place in result
            result[queue.poll()] = deck[i];

            // Move next card to bottom
            queue.add(queue.poll());
        }
        return result;
    }
}