class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] pre = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                pre[i] = s.charAt(i) == '1' ? 1 : 0;
            } else {
                pre[i] = pre[i - 1] + (s.charAt(i) == '1' ? 1 : 0);
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int ones = 0, zeros = 0;
            for (int j = i; j < n; j++) {
                ones = pre[j];
                if (i > 0) {
                    ones -= pre[i - 1];
                }
                zeros = j - i + 1 - ones;

                if (ones < (zeros * zeros)) {
                    j += (zeros * zeros) - ones - 1;
                } else {
                    ans++;
                    if (ones > (zeros * zeros)) {
                        int diff = (int) Math.sqrt(ones) - zeros;
                        int temp = diff + j;
                        if (temp >= n) {
                            ans += n - j - 1;
                        } else {
                            ans += temp-j;
                        }
                        j = temp;
                    }
                }
            }
        }
        return ans;
    }
}
