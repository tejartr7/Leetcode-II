class Solution {
    public String maximumOddBinaryNumber(String s) {
        int cnt=0;
        int i,n=s.length();
        String ans="";
        for(i=0;i<n;i++)
        {
            if(s.charAt(i)=='1')
                cnt++;
        }
        ans+='1';
        cnt-=1;
        for(i=0;i<n-cnt-1;i++)
        {
         ans='0'+ans;   
        }
        for(i=0;i<cnt;i++)
        {
            ans='1'+ans;
        }
        return ans;
    }
}