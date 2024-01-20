

class Solution {
  public int sumSubarrayMins(int[] arr) {
      int i,j,n=arr.length;
      int sum=0;
      int dp[]=new int[n];
      int m=1000_000_007;
      Stack<Integer> stack=new Stack<>();
      for(i=0;i<n;i++)
      { 
        while(!stack.isEmpty() && arr[stack.peek()]>=arr[i])
        {
          stack.pop();
        }
        if(stack.size()>0)
        {
          dp[i]=dp[stack.peek()]+(i-stack.peek())*arr[i];
        }
        else
        dp[i]=(i+1)*arr[i];
        stack.push(i);
      }
      for(int x:dp)
      {
          sum=(sum+x)%m;
      }
      return (int)sum;
  }
}