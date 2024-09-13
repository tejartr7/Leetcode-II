public class Solution {
    
    // Helper method to calculate factorial
    private long factorial(int num) {
        long fact = 1;
        for (int i = 2; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }

    // Main method to count good integers
    public long countGoodIntegers(int n, int k) {
        int n2 = (n + 1) / 2;
        long res = 0;
        Set<String> seen = new HashSet<>();

        // Iterate over all half-length palindromic candidates
        for (int v = (int) Math.pow(10, n2 - 1); v < (int) Math.pow(10, n2); v++) {
            // Generate the palindrome number
            String vv = Integer.toString(v) + new StringBuilder(Integer.toString(v)).reverse().substring(n % 2);
            String key = sortedString(vv);

            // Check divisibility by k and uniqueness of key
            if (Long.parseLong(vv) % k == 0 && !seen.contains(key)) {
                seen.add(key);

                // Count occurrences of each digit
                Map<Character, Integer> count = new HashMap<>();
                for (char c : vv.toCharArray()) {
                    count.put(c, count.getOrDefault(c, 0) + 1);
                }
                //System.out.println(count);
                // Calculate permutations using factorials
                long x = (n - count.getOrDefault('0', 0)) * factorial(n - 1);
                for (int c : count.values()) {
                    x /= factorial(c);
                }
                res += x;
            }
        }
        return res;
    }

    // Helper method to sort the characters in a string
    private String sortedString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

}
