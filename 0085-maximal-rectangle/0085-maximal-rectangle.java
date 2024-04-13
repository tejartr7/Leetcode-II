class Solution {
    public int largestRectangleArea(int[] h) {
        int ans=0;
        int i,n=h.length;
        Stack<Integer> stack=new Stack<>();
        int s[]=new int[n];
        int e[]=new int[n];
        for(i=n-1;i>=0;i--)
        {
            if(stack.isEmpty())
            {
                s[i]=-1;
            }
            else
            {
                while(!stack.isEmpty())
                {
                    if(h[stack.peek()]>=h[i])
                    stack.pop();
                    else
                    break;
                }
                if(stack.isEmpty())
                s[i]=-1;
                else
                s[i]=stack.peek();
            }
            stack.push(i);
        }
        while(!stack.isEmpty())
        stack.pop();
        for(i=0;i<n;i++)
        {
            if(stack.isEmpty())
            {
                e[i]=-1;
            }
            else
            {
                while(!stack.isEmpty())
                {
                    if(h[stack.peek()]>=h[i])
                    stack.pop();
                    else
                    break;
                }
                if(stack.isEmpty())
                e[i]=-1;
                else
                e[i]=stack.peek();
            }
            stack.push(i);
        }
        for(i=0;i<n;i++)
        {
            int x;
            if(s[i]==-1)
            {
                s[i]=n;
            }
            x=s[i]-e[i]-1;
            ans=Math.max(h[i]*x,ans);
            //System.out.println(s[i]);
        }
        return ans;
    }
    public int maximalRectangle(char[][] matrix) {
        int i,j;
        int m=matrix.length,n=matrix[0].length;
        int maxi=0;
        int dp[]=new int[n];
        for(i=0;i<m;i++)
        {
            for(j=0;j<n;j++)
            {
                if(matrix[i][j]=='0')
                {
                    dp[j]=0;
                }
                else
                {
                    dp[j]+=1;
                }
            }
            maxi=Math.max(maxi,largestRectangleArea(dp));
        }
        return maxi;
    }
}