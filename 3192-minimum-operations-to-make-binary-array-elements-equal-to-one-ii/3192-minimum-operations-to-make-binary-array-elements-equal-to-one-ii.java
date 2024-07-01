class Solution {
    public int minOperations(int[] nums) {
        int i,j,n=nums.length;
        int cnt=0;
        for(i=0;i<n;i++){
            if((nums[i]+cnt)%2==0){
                cnt++;
            }
        }
        return cnt;
    }
}