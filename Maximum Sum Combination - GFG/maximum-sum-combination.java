//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int b[] = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            List<Integer> ans = obj.maxCombinations(n, k, a, b);
            for (int e : ans) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class tuple
{
    int val;
    int i;
   
    tuple(int a,int b)
    {
        val=a;
        i=b;
    }
}
class Solution {
    static List<Integer> maxCombinations(int n, int k, int a[], int b[]) {
        // code here
        List<Integer>list=new ArrayList<>();
        PriorityQueue<tuple> pq=new PriorityQueue<>((aa,bb)->bb.val-aa.val);
        Arrays.sort(a);
        Arrays.sort(b);
        int i,j;
        for(int x:a)
        {
            pq.offer(new tuple(x+b[n-1],n-1));
        }
      //  map.get(n-1).add(n-1);
        while(pq.size()>0)
        {
            tuple top=pq.poll();
            list.add(top.val);
            int r1=top.i;
            if(list.size()==k)
            return list;
            if(r1-1>=0)
            {
                pq.offer(new tuple(top.val-b[r1]+b[r1-1],r1-1));
            }
           
        }
        return list;
    }
}