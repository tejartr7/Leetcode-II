class Solution {
    public String makeFancyString(String s) {
        int i,j,n=s.length();
        int cnt=1;
        char prev=s.charAt(0);
        StringBuilder sb=new StringBuilder();
        sb.append(prev);
        for(i=1;i<n;i++){
            char ch=s.charAt(i);
            if(prev==ch){
                cnt++;
                if(cnt>2){
                    continue;
                }
                else{
                    sb.append(ch);
                }
            }else{
                cnt=1;
                prev=ch;
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}