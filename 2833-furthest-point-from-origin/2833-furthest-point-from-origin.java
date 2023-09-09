class Solution {
    public int helper(int idx,String s)
    {
        int i,n=s.length();
        int maxi=0;
        int val=0;
        for(i=0;i<n;i++)
        {
            if(s.charAt(i)=='L')
            {
                val--;
            }
            else if(s.charAt(i)=='_')
            {
                if(Math.abs(val-1)>=Math.abs(val+1))
                {
                    val--;
                }
                else val++;
            }
            maxi=Math.max(maxi,Math.abs(val));
        }
        return maxi;
    }
    public int furthestDistanceFromOrigin(String s) {
        int maxi=0;
        int val=0;
        int temp=0;
        int i,n=s.length();
        int l=0,r=0;
        int x=0;
        for(i=0;i<n;i++)
        {
            if(s.charAt(i)=='L')
                l++;
            else if(s.charAt(i)=='R')
                r++;
            else x++;
        }
        return Math.max(l,r)+x-Math.min(l,r);
    }
}