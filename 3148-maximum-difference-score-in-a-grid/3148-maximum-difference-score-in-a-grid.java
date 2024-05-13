class Solution {
    public int maxScore(List<List<Integer>> grid) {
        int i,j,m=grid.size(),n=grid.get(0).size();
        List<List<Integer>> dp=new ArrayList<>();
        int maxi=Integer.MIN_VALUE;
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                int x=1000_000;
                if(i-1>=0)
                    x=Math.min(x,grid.get(i-1).get(j));
                if(j-1>=0)
                    x=Math.min(x,grid.get(i).get(j-1));
                int temp=grid.get(i).get(j)-x;
                maxi=Math.max(maxi,temp);
                if(x<grid.get(i).get(j))
                grid.get(i).set(j,x);
            }
            //System.out.println();
        }
        return maxi;
    }
}