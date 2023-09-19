//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();//taking testcases
		while(t-->0){
			int n=sc.nextInt();//input n
			Solution ob=new Solution();
			System.out.println(ob.getFirstSetBit(n));//calling method
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find position of first set bit in the given number.
    public static int getFirstSetBit(int n){
        int index=0;
        int i=0;
        int x=n;
        while(i<32 )
        {
            n=n>>i;
            if(n%2==1)
            return i+1;
            i++;
            n=x;
        }
        return index;
    }
}