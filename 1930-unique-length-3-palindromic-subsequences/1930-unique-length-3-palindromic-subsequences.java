class Solution {
    public int find(String s,int x,int y)
    {
        if(x==-1 || y==-1 || x==y)
            return 0;
        Set<Character> set=new HashSet<>();
        int i;
        for(i=x+1;i<y;i++)
        {
            set.add(s.charAt(i));
        }
        return set.size();
    }
    public int countPalindromicSubsequence(String s) {
        int res=0;
        int i,n=s.length();
        int f[]=new int[26];
        int l[]=new int[26];
        Arrays.fill(f,-1);
        Arrays.fill(l,-1);
        for(i=0;i<n;i++)
        {
            int x=s.charAt(i)-'a';
            if(f[x]==-1)
            {
                f[x]=i;
            }
        }
        for(i=n-1;i>=0;i--)
        {
            int x=s.charAt(i)-'a';
            if(l[x]==-1)
            {
                l[x]=i;
            } 
        }     
        for(i=0;i<26;i++)
        {
            int x=find(s,f[i],l[i]);
            res+=x;
        }
        return res;
    }
}