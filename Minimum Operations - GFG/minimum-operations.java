//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperation(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int minOperation(int n)
    {
        //code here.
        int i,j;
        int ans=0;
        if(n<=3)
        return n;
        return n%2==0?1+minOperation(n/2):2+minOperation(n/2);
    }
}