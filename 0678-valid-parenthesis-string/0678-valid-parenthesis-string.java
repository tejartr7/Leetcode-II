class Solution {
    public boolean checkValidString(String s) {
        int maxOpen=0;
        int fixedClose=0;
        int i,n=s.length();
        for(i=0;i<n;i++)
        {
            if(s.charAt(i)=='(' || s.charAt(i)=='*')
                maxOpen++;
            else
                fixedClose++;
            if(fixedClose>maxOpen)
                return false;
        }
        int maxClose=0;
        int fixedOpen=0;
        for(i=n-1;i>=0;i--)
        {
            if(s.charAt(i)==')' || s.charAt(i)=='*')
                maxClose++;
            else fixedOpen++;
            if(fixedOpen>maxClose)
                return false;
        }
        return true;
    }
}