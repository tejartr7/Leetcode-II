class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i,j,m=matrix.length,n=matrix[0].length;
        int l=0,h=m*n-1;
        while(l<=h)
        {
            int mid=(l+h)/2;
            int val=matrix[mid/n][mid%n];
            if(val==target)
                return true;
            else if(val>target)
            {
                h=mid-1;
            }
            else l=mid+1;
        }
        return false;
    }
}