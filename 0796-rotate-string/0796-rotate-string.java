class Solution {
    public boolean rotateString(String s, String goal) {
        int i,n=s.length();
        //because we cant insert or delete any character
        if(s.length()!=goal.length()) return false;
        for(i=0;i<n;i++)
        {
            String a=s.substring(0,i+1);
            String b=s.substring(i+1);
            String temp=b+a;
            if(temp.equals(goal))
                return true;
        }
        return false;
    }
}