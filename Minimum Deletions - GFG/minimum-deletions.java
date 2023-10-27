//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String S = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.minimumNumberOfDeletions(S));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int dp[];
    static boolean isPal(char[] c) {
    String temp = new String(c);
    temp = temp.replaceAll(".", "");
    int i = 0, j = temp.length() - 1;
    while (i < j) {
        if (c[i] != c[j])
            return false;
        i++;
        j--;
    }
    return true;
    }
    static int helper(int idx,char[] ch)
    {
        if(idx>=ch.length)
        {
            if(isPal(ch))
            return 0;
            return 1000_000_000;
        }
        if(dp[idx]!=-1)
        return dp[idx];
        int a=helper(idx+1,ch);
        char c=ch[idx];
        ch[idx]='.';
        int b=1+helper(idx+1,ch);
        ch[idx]=c;
       // System.out.println(idx+" "+a+" "+b);
        return dp[idx]=Math.min(a,b);
    }
    static int lcs(int x, int y, String s1, String s2)
    {
        // your code here
        int dp[][]=new int[x+1][y+1];
        int i,j;
        for(i=0;i<=x;i++)
        {
            dp[i][0]=0;
        }
        for(i=0;i<=y;i++)
        {
            dp[0][i]=0;
        }
        for(i=1;i<=x;i++)
        {
            for(j=1;j<=y;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                {
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else
                {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[x][y];
    }
    static int minimumNumberOfDeletions(String s) {
        //your code here
        dp=new int[s.length()+1];
        Arrays.fill(dp,-1);
        String rev="";
        for(int i=0;i<s.length();i++)
        rev=s.charAt(i)+rev;
        return s.length()-lcs(s.length(),s.length(),s,rev);
    }
}