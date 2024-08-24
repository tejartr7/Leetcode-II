class Solution {
    public static String helperb(String s)
{
    char ch[]=s.toCharArray();
    int i,n=ch.length;
    for(i=0;i<n/2;i++)
    {
        ch[n-1-i]=ch[i];
    }
    String a=new String(ch);
    if(a.compareTo(s)>0) return a;
    ch=s.toCharArray();
    for(i=(n-1)/2;i>=0;i--)
    {
        if(ch[i]=='9')
        {
            ch[i]='0';
        }
        else
        {
            ch[i]+=1;
            break;
        }
    }
    for(i=0;i<n/2;i++)
    {
        ch[n-1-i]=ch[i];
    }
    String b=new String(ch);
    if(ch[0]=='0')
    {
        ch[0]='1';
        String temp=new String(ch);
        temp+='1';
        b=temp;
    }
    return b;
    }
    public static String helpera(String s)
{
    char ch[]=s.toCharArray();
    int i,n=ch.length;
    for(i=0;i<n/2;i++)
    {
        ch[n-1-i]=ch[i];
    }
    String a=new String(ch);
    if(a.compareTo(s)<0) return a;
    ch=s.toCharArray();
    for(i=(n-1)/2;i>=0;i--)
    {
        if(ch[i]=='0')
        {
            ch[i]='9';
        }
        else
        {
            ch[i]-=1;
            break;
        }
    }
    for(i=0;i<n/2;i++)
    {
        ch[n-1-i]=ch[i];
    }
    String b=new String(ch);
    if(ch[0]=='0')
    {
        String str = new String(ch);
        String temp = str.substring(1);
        ch=temp.toCharArray();
        for(i=0;i<ch.length/2;i++)
        {
        ch[ch.length-1-i]=ch[i];
        }
        return new String(ch);
    }
    return b;
    }
    public String nearestPalindromic(String s) {
        if(s.equals("1")) return "0";
        if(s.equals("10") || s.equals("11")) return "9";
        String a=helpera(s);
        String b=helperb(s);  
        Long x=Long.valueOf(a);
        Long y=Long.valueOf(b);
        Long z=Long.valueOf(s);
        //System.out.println(a+" "+b+" ");
        if(Math.abs(x-z)>Math.abs(y-z)){
            return b;
        }
        return a;
    }
}