class Solution {
    public int helper(int xor,int k){
        int temp=(1<<k);
        temp--;
        for(int i=0;i<k;i++){
            if((xor>>i)%2==1){
                temp &= ~(1 << i);
            }
        }
        //System.out.println(val+" "+xor);
        return temp;
    }
    public int[] getMaximumXor(int[] nums, int k) {
        int i,j,n=nums.length;
        int arr[]=new int[n];
        for(i=0;i<n;i++){
            if(i==0) arr[i]=nums[i];
            else {
                arr[i]=nums[i]^arr[i-1];
            }
        }
        for(i=0;i<n;i++){
            nums[n-i-1]=helper(arr[i],k);
        }
        return nums;
    }   
}