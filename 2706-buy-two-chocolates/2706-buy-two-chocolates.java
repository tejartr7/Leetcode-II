class Solution {
    public int buyChoco(int[] prices, int money) {
        int min1=Integer.MAX_VALUE,min2=Integer.MAX_VALUE;
        int i,j,n=prices.length;
        for(i=0;i<n;i++)
        {
            if(prices[i]<min1)
            {
                min2=min1;
                min1=prices[i];
            }
            else if(prices[i]<min2)
            {
                min2=prices[i];
            }
        }
        if(min1+min2<=money)
            return money-min1-min2;
        return money;
    }
}