class Solution {
    public int compareVersion(String version1, String version2) {
        String[] x = version1.split("\\.");
        String[] y = version2.split("\\.");
        int i = 0, j = 0;
        int m = x.length, n = y.length;
        while (i < m || j < n) {
            int a = (i < m) ? Integer.parseInt(x[i]) : 0;
            int b = (j < n) ? Integer.parseInt(y[j]) : 0;

            if (a > b) return 1;
            else if (a < b) return -1;

            i++;
            j++;
        }

        return 0;
    }
}