class Solution {
    public long minimumOperations(int[] nums, int[] target) {
        long ans=0L;
        int i,j,n=nums.length;
        int prev=0,curr=0;
        for(i=0;i<n;i++){
            curr=target[i]-nums[i];
            if(curr>0 && prev<0){
                ans+=curr;
            }
            else if(prev>0 && curr<0){
                ans+=Math.abs(curr);
            }
            else if(Math.abs(curr)>Math.abs(prev)){
                ans+=Math.abs(curr-prev);
            }
            prev=curr;
        }
        return ans;
    }
}