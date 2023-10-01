class Solution {
    public int minSizeSubarray(int[] nums, int target) {
        int i,j,n=nums.length;
        int sum=0;
        int temp[]=new int[2*n];
        for(i=0;i<n;i++)
        {
            sum+=nums[i];
            temp[i]=nums[i];
        }   
        for(;i<2*n;i++)
            temp[i]=nums[i-n];
        int res=n;
        int k=target/sum;
        target%=sum;
        if(target==0)
            return k*n;
        Map<Long,Integer> map=new HashMap<>();
        long s=0;
        map.put(0L,-1);
        for(i=0;i<2*n;i++)
        {
            s+=nums[i%n];
            if(map.containsKey(s-target))
            {
                res=Math.min(res,i-map.get(s-target));
            }
            map.put(s,i);
        }
        return res<n?res+k*n:-1;
    }
}