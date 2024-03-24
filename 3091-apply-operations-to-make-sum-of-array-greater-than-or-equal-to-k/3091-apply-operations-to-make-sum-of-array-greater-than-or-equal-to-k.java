class Solution {
    int mini;
 
    public int minOperations(int k) {
        mini=k-1;
        int x=2;
        int t=(int)Math.sqrt(k);
        if(t*t==k)
        {
            int temp=t-1;
            temp+=t-1;
            mini=Math.min(mini,temp);
        }
        for(int i=2;i<=k;i++)
        {
            int temp=i-1;
            temp+=(k/i-1);
            if(k%i>0)
                temp++;
            mini=Math.min(mini,temp);
        }
        return mini;
    }
}