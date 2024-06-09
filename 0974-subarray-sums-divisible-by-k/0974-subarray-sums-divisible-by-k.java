class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int curr=0;
        int count=0;
        int i;
        Map<Integer,Integer> num=new HashMap<>();
        num.put(0,1);
        int n=nums.length;
        for(i=0;i<n;i++)
        {
            curr+=nums[i];
           int temp=curr%k;
            if(temp<0)
                temp+=k;
            if(num.containsKey(temp))
                count+=num.get(temp);
            num.put(temp,num.getOrDefault(temp,0)+1);
            
        }
        return count;
    }
}