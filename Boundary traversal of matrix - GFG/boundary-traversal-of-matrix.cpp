//{ Driver Code Starts
#include <bits/stdc++.h> 
using namespace std; 

// } Driver Code Ends

class Solution
{   
    public:
    //Function to return list of integers that form the boundary 
    //traversal of the matrix in a clockwise manner.
    vector<int> boundaryTraversal(vector<vector<int> > matrix, int n, int m) 
    {
        // code here
        vector<int> list;
        int i,j;
        i=0;
        for(j=0;j<m;j++)
            list.push_back(matrix[i][j]);
        if(n==1)
        return list;
        j=m-1;
        for(i=1;i<n;i++)
            list.push_back(matrix[i][j]);
        if(m==1)
        return list;
        i=n-1;
        for(j=m-2;j>=0;j--)
            list.push_back(matrix[i][j]);
        j=0;
        for(i=n-2;i>0;i--)
            list.push_back(matrix[i][j]);
        return list;
    }
};


//{ Driver Code Starts.
int main() {
    int t;
    cin>>t;
    
    while(t--) 
    {
        int n,m;
        cin>>n>>m;
        vector<vector<int> > matrix(n); 

        for(int i=0; i<n; i++)
        {
            matrix[i].assign(m, 0);
            for( int j=0; j<m; j++)
            {
                cin>>matrix[i][j];
            }
        }

        Solution ob;
        vector<int> result = ob.boundaryTraversal(matrix, n, m);
        for (int i = 0; i < result.size(); ++i)
                cout<<result[i]<<" ";
        cout<<endl;
    }
    return 0;
}
// } Driver Code Ends