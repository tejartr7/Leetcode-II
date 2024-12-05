class Solution {
    public boolean canChange(String start, String target) {
        String a=start.replaceAll("_","");
        String b=target.replaceAll("_","");
        if(!a.equals(b)) return false;
        int i=0,j=0,n=start.length();
        while(i<n)
        {
            while(i<n && start.charAt(i)=='_')
                i++;
            while(j<n && target.charAt(j)=='_')
                j++;
            if (i < n && j < n && (start.charAt(i) == 'L' && i < j || target.charAt(j) == 'R' && i > j)) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
}