class Solution {
    public boolean valid(String s,int arr[])
    {
        int i,j,n=s.length();
        int cnt[]=new int[26];
        for(i=0;i<n;i++)
        {
            cnt[s.charAt(i)-'a']++;
        }
        for(i=0;i<26;i++)
        {
            if(cnt[i]>arr[i])return false;
        }
        return true;
    }
    public int countCharacters(String[] words, String chars) {
        int i,j,m=words.length,n=chars.length();
        int[] arr=new int[26];
        int ans=0;
        for(i=0;i<n;i++)
            arr[chars.charAt(i)-'a']++;
        for(i=0;i<m;i++)
        {
            if(valid(words[i],arr))
                ans+=words[i].length();
        }
        return ans;
    }
}