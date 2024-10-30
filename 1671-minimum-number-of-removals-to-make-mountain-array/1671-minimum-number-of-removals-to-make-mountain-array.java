class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int i,j,n=nums.length;
        int mini=1000_000_000;
        int left[]=new int[n];
        int right[]=new int[n];
        Arrays.fill(left,1);
        Arrays.fill(right,1);
        for(i=1;i<n;i++){
            for(j=i-1;j>=0;j--){
                if(nums[j]<nums[i]){
                    left[i]=Math.max(left[i],1+left[j]);
                }
            }
        }
        for(i=n-2;i>=0;i--){
            for(j=i+1;j<n;j++){
                if(nums[j]<nums[i]){
                    right[i]=Math.max(right[i],1+right[j]);
                }
            }
        }
        int maxi=0;
        for(i=0;i<n-1;i++){
            if(left[i]>1 && right[i]>1){
                maxi=Math.max(maxi,left[i]+right[i]-1);
            }
        }
        return n-maxi;
    }
}