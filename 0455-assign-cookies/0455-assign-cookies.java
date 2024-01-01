class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0,j=0;
        int cnt=0;
        int m=g.length,n=s.length;
        while(i<m && j<n)
        {
            if(g[i]<=s[j])
            {
                cnt++;
                i++;
                j++;
            }
            else if(g[i]>s[j])
            {
                j++;
            }
            else i++;
        }
        return cnt;
    }
}