class Solution {
    public String multiply(String nums1, String nums2) {
        int i, j, m = nums1.length(), n = nums2.length();
        int res[] = new int[m + n + 1];
        int c = 0;
        for (i = n - 1; i >= 0; i--) {
            for (j = m - 1; j >= 0; j--) {
                int a = nums1.charAt(j) - '0';
                int b = nums2.charAt(i) - '0';
                res[i + j+1] += (a * b);
                res[i + j] += res[i + j+1] / 10;
                res[i + j+1] %= 10;
            }
        }
        StringBuilder ans = new StringBuilder();
        int idx = 0;
        while (idx < res.length && res[idx] == 0)
            idx++;
        while (idx < res.length-1) {
            ans.append(res[idx++]);
        }
        return ans.length() == 0 ? "0" : ans.toString();
    }
}
