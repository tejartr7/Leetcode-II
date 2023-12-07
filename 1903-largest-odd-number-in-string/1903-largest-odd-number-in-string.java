class Solution {
    public String largestOddNumber(String num) {
        String ans="";
        int i,j,n=num.length();
        for(i=n-1;i>=0;i--)
        {
            if((num.charAt(i)-'0')%2==1)
            {
                break;
            }
        }
        if(i==-1)
            return "";
        ans=num.substring(0,i);
        ans+=num.charAt(i);
        return ans;
    }
}