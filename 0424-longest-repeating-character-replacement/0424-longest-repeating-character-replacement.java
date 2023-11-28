class Solution {
    public int characterReplacement(String s, int k) {
        int a[]=new int[26];
        int i,n=s.length();
        Arrays.fill(a,0);
        int max=0;
        int ans=0;
        int start=0,end=0;
        while(end<n)
        {
            a[s.charAt(end)-'A']++;
            max=Math.max(a[s.charAt(end)-'A'],max);
            while((end-start+1-max)>k)
            {
                a[s.charAt(start)-'A']--;
                start++;
            }
            ans=end-start+1;
            end++;
        }
        return ans;
    }
}