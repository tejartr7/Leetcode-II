class Solution {
    public int minGroups(int[][] arr) {
        int i,j,n=arr.length;
        int cnt[]=new int[1000002];
        int ans=1;
        for(i=0;i<n;i++){
            int x=arr[i][0],y=arr[i][1];
            cnt[x]++;
            cnt[y+1]--;
        }
        for(i=1;i<=1000001;i++){
            cnt[i]+=cnt[i-1];
            ans=Math.max(cnt[i],ans);
        }
        return ans;
    }
}