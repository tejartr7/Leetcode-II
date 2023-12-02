class Solution {
    int dp[][];
    public int helper(int i,int j,String a,String b)
    {
        if(i==a.length())
        {
            return dp[i][j]=b.length()-j;
        }
        if(j==b.length())
            return dp[i][j]=a.length()-i;
        if(dp[i][j]!=-1)
            return dp[i][j];
        if(a.charAt(i)==b.charAt(j))
            return dp[i][j]=helper(i+1,j+1,a,b);
        else{
            int x=1+helper(i+1,j+1,a,b);
            int y=1+helper(i,j+1,a,b);
            int z=1+helper(i+1,j,a,b);
            return dp[i][j]=Math.min(x,Math.min(y,z));
        }
    }
    public int minDistance(String word1, String word2) {
        dp=new int[word1.length()+1][word2.length()+1];
        for(int x[]:dp)
            Arrays.fill(x,-1);
        return helper(0,0,word1,word2);
    }
}