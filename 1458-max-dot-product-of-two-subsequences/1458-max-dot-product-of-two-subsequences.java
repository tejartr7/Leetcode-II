class Solution {
    long[][] dp;
    public long helper(int i,int j,int[] a,int[] b)
    {
        int m=a.length,n=b.length;
        if(i>=m || j>=n)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        long p=helper(i+1,j+1,a,b);
        long q=a[i]*b[j]+helper(i+1,j+1,a,b);
        long r=helper(i+1,j,a,b);
        long s=helper(i,j+1,a,b);
        long x=Math.max(p,Math.max(q,Math.max(r,s)));
        dp[i][j]=x;
        return dp[i][j]==0?Integer.MIN_VALUE:x;
    }
    public int maxDotProduct(int[] nums1, int[] nums2) {
        dp=new long[501][501];
        for(long[] xx:dp)
        Arrays.fill(xx,-1);
        int p=(int)helper(0,0,nums1,nums2);
        int a=0,b=0;
        for(int x:nums1)
            if(x==0)
                a++;
        for(int x:nums2)
            if(x==0)
                b++;
        if(p!=Integer.MIN_VALUE)
        {
            if(p<0)
            {
                if(a>0 || b>0)
                    return 0;
            }
        }
        return p==Integer.MIN_VALUE?-1:p;
    }
}