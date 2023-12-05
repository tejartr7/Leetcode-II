public class Solution {

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public long beautifulSubstrings(String s, int k) {
        long vowel = 0, cons = 0, result = 0;
        Map<Long, Map<Long, Long>> mp = new HashMap<>();
        mp.put(0L, new HashMap<>());
        mp.get(0L).put(0L, 1L);

        for (char ch : s.toCharArray()) {
            if (isVowel(ch)) {
                vowel++;
            } else {
                cons++;
            }

            long pSum = vowel - cons;
            for (Map.Entry<Long, Long> entry : mp.getOrDefault(pSum, new HashMap<>()).entrySet()) {
                long pastVowelCount = entry.getKey();
                long count = entry.getValue();
                if ((vowel % k - pastVowelCount) * (vowel % k - pastVowelCount) % k == 0) //(a-b) * (a-b) % k -----> (a%k - b%k) * (a%k - b%k) %k
                    result += count;
            }

            mp.computeIfAbsent(vowel - cons, key -> new HashMap<>()).merge(vowel % k, 1L, Long::sum);
        }

        return result;
    }
}