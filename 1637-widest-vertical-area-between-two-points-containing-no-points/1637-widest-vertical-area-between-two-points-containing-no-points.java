class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points,(a,b)->a[0]!=b[0]?a[0]-b[0]:a[1]-b[1]);
        int i,j,n=points.length;
        int maxi=0;
        for(i=0;i<n-1;i++)
        {
            int temp=points[i+1][0]-points[i][0];
            maxi=Math.max(maxi,temp);
        }
        return maxi;
    }
}