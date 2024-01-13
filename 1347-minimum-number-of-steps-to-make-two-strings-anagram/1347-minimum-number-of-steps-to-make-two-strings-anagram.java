class Solution {
    public int minSteps(String s, String t) {
        int cnt1=0,cnt2=0;
        int arr[]=new int[26];
        int brr[]=new int[26];
        int i,j,n=s.length();
        for(i=0;i<n;i++)
            arr[s.charAt(i)-'a']++;
        for(i=0;i<n;i++)
            brr[t.charAt(i)-'a']++;
        for(i=0;i<26;i++)
        {
            cnt1+=Math.abs(arr[i]-brr[i]);
        }
        return cnt1/2;
    }
}