class Solution {
    public int minSubarray(int[] nums, int p) {
        long sum=0;
        int i,j,n=nums.length;
        for(i=0;i<n;i++)
        {
            sum+=nums[i];
        }
        sum%=p;
        if(sum==0) return 0;
        System.out.println(sum);
        Map<Long,Integer> map=new HashMap<>();
        map.put(0L,-1);
        long curr=0;
        int mini=n;
        for(i=0;i<n;i++){
            curr+=nums[i];
            curr%=p;
            if(map.containsKey((curr-sum+p)%p)){
                mini=Math.min(mini,i-map.get((curr-sum+p)%p));
            }
            map.put(curr,i);
        }
        return mini==n?-1:mini;
    }
}