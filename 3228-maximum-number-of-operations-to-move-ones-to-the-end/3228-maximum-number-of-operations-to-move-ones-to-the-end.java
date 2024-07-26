class Solution {
    public int maxOperations(String s) {
        int n = s.length();
        int lastZeroIndex = s.lastIndexOf('0');
        if (lastZeroIndex == -1) return 0;

        int count = 0;
        List<Integer> gaps = new ArrayList<>();

        for (int i = 0; i <= lastZeroIndex; i++) {
            char ch = s.charAt(i);
            if (ch == '0') {
                if (count > 0) {
                    gaps.add(count);
                    count = 0;
                }
            } else {
                count++;
            }
        }

        int result = 0;
        int cumulativeSum = 0;
        for (int gap : gaps) {
            cumulativeSum += gap;
            result += cumulativeSum;
        }

        return result;
    }
}
