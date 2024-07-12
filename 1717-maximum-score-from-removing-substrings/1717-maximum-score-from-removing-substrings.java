class Solution {
    private int removePairs(StringBuilder sb, String pair, int value) {
        int count = 0;
        int length = sb.length();
        for (int i = 0; i < length - 1; i++) {
            if (sb.charAt(i) == pair.charAt(0) && sb.charAt(i + 1) == pair.charAt(1)) {
                count += value;
                sb.delete(i, i + 2); // Remove the pair
                i = Math.max(-1, i - 2); // Move back to check overlapping pairs
                length -= 2; // Adjust length of string
            }
        }
        return count;
    }

    public int maximumGain(String s, int x, int y) {
        int gain1 = 0, gain2 = 0;
        StringBuilder sb1 = new StringBuilder(s);
        StringBuilder sb2 = new StringBuilder(s);

        // Prioritize higher value pair first
        if (x > y) {
            gain1 += removePairs(sb1, "ab", x);
            gain1 += removePairs(sb1, "ba", y);
        } else {
            gain2 += removePairs(sb2, "ba", y);
            gain2 += removePairs(sb2, "ab", x);
        }

        return Math.max(gain1, gain2);
    }
}
