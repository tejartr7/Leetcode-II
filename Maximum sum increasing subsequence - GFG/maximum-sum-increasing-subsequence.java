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
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSumIS(Arr,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int[] dp;
    public int helper(int idx,int prev,int arr[])
    {
        int n=arr.length;
        if(idx>=n)
        return 0;
        if(dp[idx]!=-1)
        return dp[idx];
        int x=helper(idx+1,prev,arr);
        int y=0;
        if(prev<arr[idx])
        y=arr[idx]+helper(idx+1,arr[idx],arr);
        return dp[idx]=Math.max(x,y);
    }
	public int maxSumIS(int arr[], int n)  
	{  
	    //code here.
	    dp=new int[n];
	    int[] sum=new int[n];
	    int i,j;
	    Arrays.fill(dp,-1);
	    for(i=n-1;i>=0;i--)
	    {
	       sum[i]=arr[i];
	       int curr=arr[i];
	       for(j=i+1;j<n;j++)
	       {
	           if(arr[j]>arr[i])
	           sum[i]=Math.max(sum[i],arr[i]+sum[j]);
	       }
	    }
	    int maxi=0;
	    for(int x:sum)
	    {
	       // System.out.print(x+" ");
	        maxi=Math.max(x,maxi);
	    }
	   // System.out.println();
	    return maxi;
	}  
}