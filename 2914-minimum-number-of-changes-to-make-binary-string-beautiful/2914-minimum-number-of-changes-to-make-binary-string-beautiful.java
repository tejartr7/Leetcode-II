class Solution {
    public int minChanges(String s) {
        int cnt=1;
        int i,j,n=s.length();
        int ans=0;
        i=1;
        j=0;
        for(i=0;i<n;i+=2)
        {
            if(s.charAt(i)!=s.charAt(i+1))
            {
                ans++;
            }
        }
        return ans;
    }
}