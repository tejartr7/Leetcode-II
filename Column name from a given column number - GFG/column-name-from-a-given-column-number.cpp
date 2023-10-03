//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends


class Solution{
    public:
    string colName (long long int n)
    {
        // your code here
         string result = "";
        while(n>0){
            long long int rem = n%26;
            if(rem == 0){
                rem = 26;
                n -= 1;
            }
            char ch = 'A' + rem - 1;
            result = ch + result;
            n /= 26;
        }
        return result;
    }
};

//{ Driver Code Starts.
int main()
{
    int t; cin >> t;
    while (t--)
	{
		long long int n; cin >> n;
		Solution ob;
		cout << ob.colName (n) << '\n';
	}
}

// } Driver Code Ends