//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends

class Solution {
public:
    vector<int> pre; // Changed int pre[] to vector<int> pre

    int helper(int idx, int n, int arr[], int sum, vector<vector<int>>& dp) {
        int mod = 1000000007;
        if (sum == 0) {
            int val = 0;
            if (idx <= n - 1)
                val = pre[idx];
            if (val == 0)
                return 1;
            
            return (1 << (val));
        }
        if (idx >= n)
            return 0;
        if (dp[idx][sum] != -1)
            return dp[idx][sum];
        int take = 0;
        int notTake = helper(idx + 1, n, arr, sum, dp);
        if (arr[idx] <= sum)
            take = helper(idx + 1, n, arr, sum - arr[idx], dp);
        return dp[idx][sum] = (take % mod + notTake % mod) % mod;
    }

    int perfectSum(int arr[], int n, int sum) {
        vector<vector<int>> dp(n, vector<int>(sum + 1, -1));
        pre.resize(n); // Resized the vector
        int cnt = 0;
        int i;
        for (i = n - 1; i >= 0; i--) { // Corrected the loop condition
            if (arr[i] == 0)
                cnt++;
            pre[i] = cnt;
        }
        return helper(0, n, arr, sum, dp);
    }
};

//{ Driver Code Starts.
int main() 
{
   	
   
   	int t;
    cin >> t;
    while (t--)
    {
        int n, sum;

        cin >> n >> sum;

        int a[n];
        for(int i = 0; i < n; i++)
        	cin >> a[i];

       

	    Solution ob;
	    cout << ob.perfectSum(a, n, sum) << "\n";
	     
    }
    return 0;
}

// } Driver Code Ends