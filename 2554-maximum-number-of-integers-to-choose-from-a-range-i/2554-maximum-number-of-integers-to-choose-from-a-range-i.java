class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Arrays.sort(banned);
        int i,j;
        int l=0,r=n;
        int ans=-1;
        while(l<=r){
            int mid=(l+r)/2;
            int sum=(mid*(mid+1))/2;
            int cnt=mid;
            Set<Integer> set = new HashSet<>();
            for(int x:banned){
                if(x<=mid && !set.contains(x)){
                    sum-=x;
                    cnt--;
                    set.add(x);
                }
            }
            if(sum<=maxSum){
                ans=Math.max(ans,cnt);
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return ans;
    }
}