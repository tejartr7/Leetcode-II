class Solution {
    public boolean pal(char []c)
    {
        int i=0,n=c.length-1;
        while(i<n)
        {
            if(c[i]==c[n])
            {
                i++;
                n--;
            }
            else
                return false;
        }
        return true;
    }
    public String firstPalindrome(String[] words) {
        int i,n=words.length;
        String x="";
        for(i=0;i<n;i++)
        {
            boolean d=pal(words[i].toCharArray());
            if(d)
                return words[i];
        }
        return x;
    }
}