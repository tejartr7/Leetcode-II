class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int i,j,n=nums.length;
        int cnt[]=new int[32];
        i=0;j=0;
        int ans=1000_000_000;
        int curr=0;
        while(j<n){
            int temp=nums[j];
            int x=0;
            while(temp>0){
                if(temp%2==1)
                    cnt[x]++;
                temp/=2;
                x++;
            }
            curr|=nums[j];
            while(curr>=k && i<=j){
                ans=Math.min(ans,j-i+1);
                temp=nums[i];
                x=0;
                while(temp>0){
                    if(temp%2==1)
                    cnt[x]--;
                    temp/=2;
                    x++;
                }
                curr=0;
                for(x=0;x<32;x++){
                    if(cnt[x]>0)
                        curr|=(1<<x);
                }
                i++;
            }
            j++;
        }
        return ans==1000_000_000?-1:ans;
    }
}