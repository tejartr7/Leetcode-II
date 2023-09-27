//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class GFG {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String[] element = br.readLine().split(" ");
		    int N = Integer.parseInt(element[0]);
		    int M = Integer.parseInt(element[1]);
		    int arr [] = new int[N];
		    int brr [] = new int[M];
		    String[] elements = br.readLine().split(" ");
		    for(int i=0; i<N; i++)
		        arr[i] = Integer.parseInt(elements[i]);
		        
		    String[] ele = br.readLine().split(" ");
		    for(int i=0; i<M; i++)
		        brr[i] = Integer.parseInt(ele[i]);
		    
		    int X = Integer.parseInt(br.readLine());
		    
		    Solution obj = new Solution();
		    ArrayList<Integer> ans;
		    ans = obj.printClosest(arr, brr, N, M, X);
		    System.out.println(Math.abs(ans.get(0) + ans.get(1) - X));
		}
	}
}


// } Driver Code Ends


//User function Template for Java



//User function Template for Java

class Solution{
    // Function for finding maximum and value pair
    public static int bsf(int arr[],int x)
    {
        int ans=-1;
        int l=0,h=arr.length-1;
        while(l<=h)
        {
            int mid=(l+h)/2;
            if(arr[mid]==x)
            return arr[mid];
            else if(arr[mid]<x)
            {
                ans=arr[mid];
                l=mid+1;
            }
            else h=mid-1;
        }
        return ans;
    }
    public static int bsc(int arr[],int x)
    {
        int ans=-1;
        int l=0,h=arr.length-1;
        while(l<=h)
        {
            int mid=(l+h)/2;
            if(arr[mid]==x)
            return arr[mid];
            else if(arr[mid]>x)
            {
                ans=arr[mid];
                h=mid-1;
            }
            else l=mid+1;
        }
        return ans;
    }
    public static ArrayList<Integer> printClosest (int arr[], int brr[], int n, int m, int x) {
        // code here
        ArrayList<Integer> list=new ArrayList<>();
        int a=-1,b=-1;
        int diff=Integer.MAX_VALUE;
        int i=0,j=m-1;
        while(i<n && j>=0)
        {
            int sum=arr[i]+brr[j];
            if(Math.abs(x-sum)<diff)
            {
                list.clear();
                diff=Math.abs(x-sum);
                list.add(arr[i]);
                list.add(brr[j]);
            }
            if(sum<x)
            i++;
            else j--; 
        }
        //System.out.println(a+" "+b);
        list.add(a);
        list.add(b);
        return list;
    }
}