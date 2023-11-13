class Solution {
    public String sortVowels(String s) {
        String x="";
        String ans="";
        int i,n=s.length();
        char ch[]=new char[n];
        Arrays.fill(ch,'.');
        String temp="aeiouAEIOU";
        for(i=0;i<n;i++)
        {
            char c=s.charAt(i);
            String dummy="";
            dummy+=c;
            if(temp.contains(dummy))
            {
                x+=c;
            }
            else 
                ch[i]=c;
        }
        char t[]=x.toCharArray();
        Arrays.sort(t);
        int j=0;
        for(i=0;i<n;i++)
        {
            if(ch[i]=='.')
            {
                ch[i]=t[j++];
            }
        }
        return new String(ch);
    }
}