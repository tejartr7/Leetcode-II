public class Solution {
    public long helper(String a, String s, int limit) {
        if (a.length() < s.length())
            return 0L;
        if (a.length() == s.length()) {
            if (a.compareTo(s) >= 0)
                return 1;
            return 0;
        }
        long ans = 0;
        String sub = a.substring(a.length() - s.length());
        int len = a.length() - s.length();
        int i;
        for (i = 0; i < len; i++) {
            if (limit < (a.charAt(i) - '0')) {
                ans += (long) Math.pow(limit + 1, len - i);
                return ans;
            } else {
                ans += (long) (a.charAt(i) - '0') * (long) Math.pow(limit + 1, len - 1 - i);
            }
        }
        if (sub.compareTo(s) >= 0)
            ans++;
        return ans;
    }

    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        String a = String.valueOf(start - 1);
        String b = String.valueOf(finish);
        return helper(b, s, limit) - helper(a, s, limit);
    }
}
