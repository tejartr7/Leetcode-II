class Solution {
  public char findKthBit(int n, int k) {
        return getChar("0", n, k);
    }
    public char getChar(String s,int n,int k)
    {
        if(k<=s.length())
            return s.charAt(k-1);
        return getChar(s+"1"+reverse(s.toCharArray()),n-1,k);
    }
    public String reverse(char []t)
    {   char []c=invert(t);
        int i=0,n=c.length-1;
        while(i<n)
        {
            char temp=c[i];
            c[i]=c[n];
            c[n]=temp;
            n--;
            i++;
        }
        return new String(c);
    }
    public char[] invert(char []t)
    {
        int i,n=t.length;
        for(i=0;i<n;i++)
        {
            if(t[i]=='1')
                t[i]='0';
            else
                t[i]='1';
        }
        return t;
    }
}