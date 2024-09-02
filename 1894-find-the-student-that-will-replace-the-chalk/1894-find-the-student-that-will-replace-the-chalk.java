class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int i,n=chalk.length;
        long pre[]=new long[n];
        int sum=0;
        pre[0]=chalk[0];
        for(i=1;i<n;i++)
        {
            pre[i]=pre[i-1]+chalk[i];
        }
        for(i=0;i<n;i++)
        {
            long x=pre[i]+k/pre[n-1]*pre[n-1];
            if(x>k)
                return i;
        }
        return -1;
    }
}