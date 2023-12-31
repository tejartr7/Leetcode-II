class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int i,j,n=s.length();
        int ans=-1;
        int []cnt=new int[26];
        Arrays.fill(cnt,-1);
        for(i=n-1;i>=0;i--)
        {
            int x=s.charAt(i)-'a';
            if(cnt[x]==-1)
                cnt[x]=i;
        }
        for(i=0;i<n;i++)
        {
            int x=s.charAt(i)-'a';
            ans=Math.max(ans,cnt[x]-i-1);
        }
        return ans;
    }
}