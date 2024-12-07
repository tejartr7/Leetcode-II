class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int i,j,n=nums.length;
        int l=1,r=1000000000;
        int ans=-1;
        while(l<=r){
            int mid=(l+r)/2;
            int count=0;
            int maxi=0;
            for(i=0;i<n;i++){
                count+=((nums[i])/mid-1);
                if(nums[i]%mid!=0){
                    count++;
                }
            }
            if(count<=maxOperations){
                ans=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
}