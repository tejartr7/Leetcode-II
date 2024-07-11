class Solution {
    public long countSubarrays(int[] nums, int k) {
        return atLeastK(nums,k)-atLeastK(nums,k+1);
    }
    public long atLeastK(int nums[],int k){
        long ans=0;
        int i,j,n=nums.length;
        i=0;j=0;
        int bits[]=new int[32];
        while(j<n){
            for(int x=0;x<32;x++){
                if((nums[j]>>x)%2==1){
                   bits[x]++; 
                }
            }
            while(j-i+1>0 && andVal(bits,j-i+1)<k){
                for(int x=0;x<32;x++){
                    if((nums[i]>>x)%2==1){
                       bits[x]--; 
                    }
                }
                i++;
            }
            j++;
            ans+=j-i+1;
        }
        return ans;
    }
    public long andVal(int []temp,int len){
        long ans=0;
        for(int i=0;i<32;i++){
            if(temp[i]==len){
                ans|=(1<<i);
            }
        }
        return ans;
    }
}