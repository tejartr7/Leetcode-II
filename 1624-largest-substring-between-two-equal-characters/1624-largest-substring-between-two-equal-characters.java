class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int i,j,n=s.length();
        int ans=-1;
        for(i=0;i<n-1;i++)
        {
            for(j=n-1;j>i;j--)
            {
                if(s.charAt(i)==s.charAt(j))
                {
                    ans=Math.max(ans,j-i-1);
                    break;
                }
            }
        }
        return ans;
    }
}