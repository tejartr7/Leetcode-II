class Solution {
    public int trap(int[] h) {
        int max=0,n=h.length,i;
        int a[]=new int[n];
        int b[]=new int[n];
        a[0]=h[0];
        b[n-1]=h[n-1];
        for(i=1;i<n;i++)
            a[i]=Math.max(a[i-1],h[i]);
        for(i=n-2;i>=0;i--)
            b[i]=Math.max(b[i+1],h[i]);
        for(i=0;i<n;i++)
        {
            int min=Math.min(a[i],b[i]);
            if(min>h[i])
                max+=min-h[i];
        }
        return max;
        
    }
}