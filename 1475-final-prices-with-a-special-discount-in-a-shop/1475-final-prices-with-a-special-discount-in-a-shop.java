class Solution {
    public int[] finalPrices(int[] prices) {
        int i,j,n=prices.length;
        Stack<Integer> stack=new Stack<>();
        for(i=0;i<n;i++){
            while(stack.size()>0 && prices[stack.peek()]>=prices[i])
            {
                int idx=stack.pop();
                prices[idx]-=prices[i];
            }
            stack.push(i);
        }
        return prices;
    }
}