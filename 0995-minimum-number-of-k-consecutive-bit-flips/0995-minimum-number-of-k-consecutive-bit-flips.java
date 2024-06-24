class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int i,j,n=nums.length;
        boolean vis[]=new boolean[n];
        int ans=0;
        int flip=0;
        for(i=0;i<n;i++){
            if(i>=k && vis[i-k]){
                flip--;
            }
            if(flip%2==nums[i]){
                if(i+k>n) return -1;
                flip++;
                ans++;
                vis[i]=true;
            }
        }
        return ans;
    }
}