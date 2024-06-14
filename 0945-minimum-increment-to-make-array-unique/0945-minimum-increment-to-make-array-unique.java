class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int i,j,n=nums.length;
        boolean temp[]=new boolean[10000001];
        j=nums[0];
        int ans=0;
        for(i=0;i<n;i++){
            j=Math.max(j,nums[i]);
            while(temp[j]){
                j++;
            }
            temp[j]=true;
            if(j>nums[i])
            ans+=j-nums[i];
        }
        return ans;
    }
}