class Solution {
    public String addSpaces(String s, int[] spaces) {
        int i,j,n=spaces.length;
        int idx=0;
        StringBuilder sb=new StringBuilder();
        for(i=0;i<s.length();i++){
            if(idx<n && i==spaces[idx]){
                sb.append(" ");
                idx++;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}