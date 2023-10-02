//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.distinctSubsequences(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    

    int distinctSubsequences(String s) {
       int i,j;
       int n=s.length();
       int[] dp=new int[n+1];
       int mod=1000_000_007;
       dp[0]=1;
       Map<Character, Integer> map = new HashMap<>();
       for(i=1;i<=n;i++)
       {
           char ch=s.charAt(i-1);
           int val=(2*dp[i-1]%mod);
           if(map.containsKey(ch))
           {
               val=(val%mod-dp[map.get(ch)-1]+mod)%mod;
           }
           map.put(ch,i);
           dp[i]=val%mod;;
       }
       return dp[n]%mod;
    }
}
