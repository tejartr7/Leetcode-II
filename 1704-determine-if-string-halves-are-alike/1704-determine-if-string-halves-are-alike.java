class Solution {
    public boolean halvesAreAlike(String s) {
        int cnt1=0,cnt2=0,n=s.length();
        String a=s.substring(0,n/2).toLowerCase();
        String b=s.substring(n/2).toLowerCase();
        for(int i=0;i<n/2;i++)
        {
            if(a.charAt(i)=='a' || a.charAt(i)=='e' || a.charAt(i)=='i' || a.charAt(i)=='o' || a.charAt(i)=='u')
                cnt1++;
        }
        for(int i=0;i<n/2;i++)
        {
            if(b.charAt(i)=='a' || b.charAt(i)=='e' || b.charAt(i)=='i' || b.charAt(i)=='o' || b.charAt(i)=='u')
                cnt2++;
        }
        return cnt1==cnt2;
    }
}