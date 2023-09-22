//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java



class GFG
{
    int bsf(int arr[],int x)
    {
        int i=0,j=arr.length-1;
        while(i<j)
        {
            int mid=(i+j)/2;
            if(arr[mid]<=x)
            j=mid-1;
            else i=mid+1;
        }
        return i;
    }
     int bsc(int arr[],int x)
    {
        int i=0,j=arr.length-1;
        while(i<j)
        {
            int mid=(i+j)/2;
            if(arr[mid]<=x)
            j=mid-1;
            else i=mid+1;
        }
        return j;
    }
    ArrayList<Integer> find(int arr[], int n, int x)
    {
        // code here
        int a=bsf(arr,x);
        int b=bsc(arr,x);
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(arr[i]==x)
            {
                list.add(i);
                break;
            }
        }
        for(int i=n-1;i>=0;i--)
        {
             if(arr[i]==x)
            {
                list.add(i);
               break;
            }
        }
        if(list.size()==0)
        {
            list.add(-1);
            list.add(-1);
            return list;
        }
        if(list.size()==1)
        {
            list.add(list.get(0));
            return list;
        }
        return list;
    }
}




//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
//            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int x =Integer.parseInt(q[1]);
//            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(a1[i]);
            }
            GFG ob = new GFG();
            ArrayList<Integer> ans=ob.find(arr,n,x);
            System.out.println(ans.get(0)+" "+ans.get(1));
        }
    }
}

// } Driver Code Ends