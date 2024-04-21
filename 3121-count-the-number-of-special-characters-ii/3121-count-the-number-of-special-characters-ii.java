class Solution {
    public int numberOfSpecialChars(String word) {
        int i,j,n=word.length();
        int a[]=new int[26];
        int b[]=new int[26];
        Arrays.fill(a,-1);
        Arrays.fill(b,-1);
        for(i=0;i<n;i++)
        {
            char ch=word.charAt(i);
            if(ch>='a' && ch<='z')
            {
                a[ch-'a']=i;
            }
            if(ch>='A' && ch<='Z' && b[ch-'A']==-1)
            {
                b[ch-'A']=i;
            }
        }
        int cnt=0;
        for(i=0;i<26;i++)
        {
            if(a[i]!=-1 && b[i]!=-1 && a[i]<b[i]) cnt++;
        }
        return cnt;
    }
}