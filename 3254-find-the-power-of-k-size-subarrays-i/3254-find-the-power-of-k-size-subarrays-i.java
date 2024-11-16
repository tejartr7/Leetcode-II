class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int i,j,n=nums.length;
        int arr[]=new int[n];
        int ans[]=new int[n-k+1];
        Arrays.fill(arr,1);
        Arrays.fill(ans,-1);
        for(i=1;i<n;i++){
            if(nums[i]==nums[i-1]+1){
                arr[i]=1+arr[i-1];
            }
        }
        // for(i=0;i<n;i++)
        //     System.out.print(arr[i]+" ");
        for(i=k-1;i<n;i++){
            //System.out.println(arr[i]+" "+k+" "+i);
            if(arr[i]>=k){
                ans[i-(k-1)]=nums[i];
            }
        }
        return ans;
    }
}