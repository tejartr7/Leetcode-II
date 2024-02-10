class Solution {
    public int countSubstrings(String s) {
        //ask abt sql
        int count=0;
        int i,j,n=s.length();
        for(i=0;i<n;i++)
        {
            int x=i,y=i;
            while(x>=0 && y<n && s.charAt(x)==s.charAt(y))
            {
                x--;
                y++;
                count++;
            }
            x=i;
            y=i+1;
            while(x>=0 && y<n && s.charAt(x)==s.charAt(y))
            {
                x--;
                y++;
                count++;
            }
        }
        return count;
    }
}