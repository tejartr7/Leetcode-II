class Solution {
    public int scoreOfString(String s) {
        int ans=0;
        int i,j,n=s.length();
        for(i=0;i<n-1;i++)
        {
            int x=Math.abs(s.charAt(i)-s.charAt(i+1));
            ans+=x;
        }
        return ans;
    }
}