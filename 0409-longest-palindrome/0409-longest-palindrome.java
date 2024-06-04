class Solution {
    public int longestPalindrome(String s) {
        int i,j,n=s.length();
        int a[]=new int[52];
        for(i=0;i<n;i++){
            if(s.charAt(i)>='a')
            a[s.charAt(i)-'a'+26]++;
            else a[s.charAt(i)-'A']++;
        }
        int ans=0;
        int odd=0;
        for(i=0;i<52;i++){
            ans+=a[i]/2*2;
            if(a[i]%2==1){
                odd++;
            }
        }
        if(odd>0)ans++;
        return ans;
    }
}