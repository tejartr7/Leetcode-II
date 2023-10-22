//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG { 
    
	public static void main (String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int M = Integer.parseInt(inputLine[0]);
		    int N = Integer.parseInt(inputLine[1]);
		    Solution ob = new Solution();
		    System.out.println(ob.numberOfPaths(M, N));
		}
	}
}




// } Driver Code Ends


class Solution{
    public long MOD=1000000007;
    long modpow(long x, long n, long p)
    {
        if (n == 0)
            return 1 % p;
        long ans = 1, base = x;
        while (n > 0)
        {
            if (n % 2 == 1)
            {
                ans = (ans * base) % p;
                n--;
            }
            else
            {
                base = (base * base) % p;
                n /= 2;
            }
        }
        if (ans < 0)
            ans = (ans + p) % p;
        return ans;
    }    
    
    long numberOfPaths(int M, int N) {
        long path = 1;
        for (long i = N; i < (M + N - 1); i++) {
            path = (path*i)%MOD;
            long inv=modpow(i-N+1,MOD-2,MOD);
            path = (path*inv)%MOD;
        }
        return path;        
    }
}