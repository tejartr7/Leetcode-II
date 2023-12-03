class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans=0;
        int i,j,n=points.length;
        for(i=0;i<n-1;i++)
        {
            int x=Math.abs(points[i][0]-points[i+1][0]);
            int y=Math.abs(points[i][1]-points[i+1][1]);
            ans+=Math.max(x,y);
        }
        return ans;
    }
}