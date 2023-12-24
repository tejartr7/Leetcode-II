class Solution {
    public int minOperations(String s) {
        int cnt1=0,cnt2=0;
        int i,j,n=s.length();
        char[] ch=s.toCharArray();
       // String p="",q="";
        int p=s.charAt(0)-'0';
        for(i=1;i<n;i++)
        {
            if(s.charAt(i)-'0'!=1-p)
            {
                cnt1++;
            }
            p=1-p;
        }
        p=1-(s.charAt(0)-'0');
        cnt2=1;
        for(i=1;i<n;i++)
        {
            if(s.charAt(i)-'0'!=1-p)
            {
                cnt2++;
            }
            p=1-p;
        }
        return Math.min(cnt1,cnt2);
    }
}