class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        int i,j,n=nums.length;
        int sum=0;
        map.put(0,-1);
        for(i=0;i<n;i++){
            sum+=nums[i];
            if(map.containsKey(sum%k)){
                int len=i-map.get(sum%k);
                if(len>1) return true;
            }
            else map.put(sum%k,i);
        }
        return false;
    }
}