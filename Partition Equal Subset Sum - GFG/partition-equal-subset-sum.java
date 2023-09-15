//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
   static boolean helper(int nums[],int curr,int i,int sum,int k)
    {
        if(k==0)
        return true;
        if(sum==curr)
        {
            return helper(nums,curr,0,0,k-1);
        }
        int j,n=nums.length;
        for(j=i;j<n;j++)
        {
            if(nums[j]<0 || nums[j]+sum>curr)
            continue;
            int x=nums[j];
            nums[j]=-1;
            if(helper(nums,curr,j+1,sum+x,k))
            return true;
            nums[j]=x;
        }
        return false;
    } 

    static int equalPartition(int n, int arr[]) { // Changed return type to boolean
        // code here
        int i, j, k = 2;
        int sum = 0;
        for (int x : arr)
            sum += x;
        if (sum % 2 == 1)
            return 0; // Return false if the sum is odd
        return helper(arr,sum/2,0,0,2)?1:0; // Changed 2 to k
    }
}
