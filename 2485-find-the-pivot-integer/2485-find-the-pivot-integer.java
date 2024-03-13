class Solution {
    public int pivotInteger(int n) {
        int sum=((n)*(n+1))/2;
        int a=-1,b=-1;
        int i;
        int curr=0;
        for(i=1;i<=n;i++)
        {
            curr+=i;
            if(sum==curr)
            {
                a=i;
                break;
            }
            sum-=i;
        }
        return a;
    }
}