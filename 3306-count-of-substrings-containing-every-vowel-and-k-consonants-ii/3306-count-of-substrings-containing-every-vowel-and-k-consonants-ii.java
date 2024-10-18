class Solution {
    public long helper(String word, int k) {
        int i, j, n = word.length();
        int arr[] = new int[26];
        int c = 0, l = 0, r = 0;
        long ans = 0;
        String temp = "aeiou";

        while (r < n) {
            char ch = word.charAt(r);

            if (temp.indexOf(ch) != -1) {
                arr[ch - 'a']++;
            } else {
                c++;
            }

            while (c >= k && arr[0] > 0 && arr['e' - 'a'] > 0 && arr['i' - 'a'] > 0 && arr['o' - 'a'] > 0 && arr['u' - 'a'] > 0) {
                ans += n - r;
                char t = word.charAt(l);
                if (temp.indexOf(t) != -1) {
                    arr[t - 'a']--;
                } else {
                    c--;
                }
                l++;
            }
            r++;
        }

        return ans;
    }

    public long countOfSubstrings(String word, int k) {
        return helper(word, k) - helper(word, k + 1);
    }
}
