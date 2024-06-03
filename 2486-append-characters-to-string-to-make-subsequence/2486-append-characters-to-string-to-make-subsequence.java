class Solution {
    public int appendCharacters(String s, String t) {
        int count=0;
        int i=0,j=0;
        int m=s.length(),n=t.length();
        while(i<m && j<n)
        {
            if(s.charAt(i)==t.charAt(j))
            {
                j++;
            }
            i++;
        }
        return n-j;
    }
}