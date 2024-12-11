class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int maxi=0;
        int i,j,n=nums.length;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;    
 for(int x:nums)
        {
            int a=x-k;
            int b=x+k;
 min=Math.min(min,Math.min(a,b));
     max=Math.max(max,Math.max(a,b));
 }
        int pre[]=new int[300003];
        Arrays.fill(pre,0);
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int x:nums)
        {
            int a=x-k;
            int b=x+k;
            pre[x]+=1;
            pre[x+2*k+1]-=1;
        }
        //System.out.println(map);
        int sum=0;
        for(i=0;i<pre.length;i++)
        {
           sum+=pre[i];
           maxi=Math.max(sum,maxi); 
        }
        return maxi;
    }
}