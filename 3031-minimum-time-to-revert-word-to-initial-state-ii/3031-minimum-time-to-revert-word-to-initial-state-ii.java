class Solution {
    long pre[];
    long prime = 31;  // Choose a prime number for hashing

    public int minimumTimeToInitialState(String word, int k) {
        int count = 1;
        pre = new long[word.length()];

        // Make pre array using rolling hash (Rabin-Karp)
        pre[0] = word.charAt(0) - 'a' + 1;
        for (int i = 1; i < word.length(); i++) {
            pre[i] = pre[i - 1] + (word.charAt(i) - 'a' + 1) * power(prime, i);
        }

        for (int i = k; i < word.length(); i += k) {
            if (checkPrefix(word, i, k))
                return count;
            count++;
        }
        return count;
    }

    private boolean checkPrefix(String word, int idx, int k) {
        int n = word.length();

        long hash1 = pre[n - 1] - (idx > 0 ? pre[idx - 1] : 0);
        long hash2 = pre[n - idx - 1];

        return hash1 == hash2 * power(prime, idx);
    }

    private long power(long base, int exponent) {
        long result = 1;
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base);
            }
            base = (base * base);
            exponent /= 2;
        }
        return result;
    }
}
