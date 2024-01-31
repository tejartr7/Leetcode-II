class Solution {
    public int[] dailyTemperatures(int[] t) {
       int i,n=t.length;    
       Stack<Integer> stack=new Stack<>();
       int a[]=new int[n];
       for(i=0;i<n;i++)
       {
           while(!stack.isEmpty() && t[stack.peek()]<t[i])
           {
               int index=stack.pop();
               a[index]=i-index;
           }
           stack.push(i);
       }
       return a;
    }
}