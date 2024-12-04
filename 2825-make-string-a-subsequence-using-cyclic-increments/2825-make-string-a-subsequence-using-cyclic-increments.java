class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int i,j;
        int m=str1.length(),n=str2.length();
        i=0;j=0;
        while(i<m && j<n)
        {
            char t=(char)((str1.charAt(i)-'a'+1)%26+'a');
            if(str1.charAt(i)==str2.charAt(j) || str2.charAt(j)==t)
            {
                i++;
                j++;
            }
            else i++;
        }
        return j==n;
    }
}