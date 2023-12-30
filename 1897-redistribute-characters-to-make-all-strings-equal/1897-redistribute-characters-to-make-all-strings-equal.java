class Solution {
    public boolean makeEqual(String[] words) {
        int n=words.length;
        int cnt[]=new int[26];
        for(String x:words)
        {
            for(int i=0;i<x.length();i++)
            {
                cnt[x.charAt(i)-'a']++;
            }
        }
        for(int i=0;i<26;i++)
        {
            if(cnt[i]%n!=0)
                return false;
        }
        return true;
    }
}