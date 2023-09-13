//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++


class Solution{
public:
    string findLargest(int n, int s){
        // code here
        string ans="";
        int val=9;
        int begin=s;
        while(n>0)
        {
            while(val>s)
            {
                val--;
            }
            //cout<<s<<" "<<val<<endl;
            ans+=char(val-0+'0');
            s-=val;
            n--;
        }
        if(ans[0]=='0' && ans.size()>1)
        return "-1";
        if(s!=0)
        return "-1";
        return ans;
    }
};


//{ Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        int N, S;
        cin>>N>>S;
        
        Solution ob;
        cout<<ob.findLargest(N, S)<<"\n";
    }
    return 0;
}
// } Driver Code Ends