class Solution {
    int mini;
 
    public int minOperations(int k) {
        mini=k-1;
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