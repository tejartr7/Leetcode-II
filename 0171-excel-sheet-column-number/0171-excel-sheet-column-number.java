class Solution {
    public int titleToNumber(String c) {
        int j=c.length();
        int l=j;
        int i;
        int a=0;
        for(i=0;i<l;i++)
        {
            int k=c.charAt(i)-64;
            a+=Math.pow(26,j-1)*k;
            j--;
        }
        return a;
    }
}