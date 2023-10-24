//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int dp[][];
    static boolean pal(int i,int j,String s)
    {
        while(i<j)
        {
            if(s.charAt(i)!=s.charAt(j))
            return false;
            i++;
            j--;
        }
        return true;
    }
    static int helper(int i,int j,String str)
    {
        int x,y,n=str.length();
        if(j>=n)
        {
            return pal(i,j-1,str)?0:1000_000_000;
        }
        int mini=Integer.MAX_VALUE;
        int p=1000_000_000;
        int q=p;
        if(dp[i][j]!=-1)
        return dp[i][j];
        if(pal(i,j,str))
        q=1+helper(j+1,j+1,str);
        p=helper(i,j+1,str);
        return dp[i][j]=Math.min(p,q);
    }
    static int palindromicPartition(String str)
    {
        // code here
        int i,j,n=str.length();
        dp=new int[n][n];
        for(int r[]:dp)
        Arrays.fill(r,-1);
        return helper(0,0,str);
    }
}