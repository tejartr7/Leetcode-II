class Solution {
    int[] dp = new int[100001];

int search(int[][] v, int i, int m) {
    int left = i + 1;
    int right = m - 1;
    int k = -1;
    
    while (left <= right) {
        int mid = left + (right - left) / 2;
        
        if (v[mid][0] > v[i][1]) {
            k = mid;
            right = mid - 1; // Continue searching in the left half
        } else {
            left = mid + 1; // Continue searching in the right half
        }
    }
    
    return k;
}


    int solve(int i, int[][] v, int m) {
        if (i >= m)
            return 0;
        if (dp[i] != -1)
            return dp[i];
        int a = solve(i + 1, v, m);
        int k = search(v, i, m);
        int b = v[i][2];
        if (k != -1)
            b = v[i][2] + solve(k, v, m);
        return dp[i] = Math.max(a, b);
    }

    public int maximizeTheProfit(int n, List<List<Integer>> list) {
        Arrays.fill(dp, -1);
        int[][] v=new int[list.size()][3];
        int i,j;
        for(i=0;i<list.size();i++)
        {
            v[i][0]=list.get(i).get(0);
            v[i][1]=list.get(i).get(1);
            v[i][2]=list.get(i).get(2);
        }
        Arrays.sort(v, (a, b) -> Integer.compare(a[0], b[0]));
        int m = v.length;
        int ans = solve(0, v, m);
        return ans;
    }
}