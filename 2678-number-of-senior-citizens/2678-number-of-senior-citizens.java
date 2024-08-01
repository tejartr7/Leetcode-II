class Solution {
    public int countSeniors(String[] details) {
        int cnt=0;
        for(String x:details){
            int a=x.charAt(11)-'0';
            int b=x.charAt(12)-'0';
            int temp=a*10+b;
            if(temp>60) cnt++;
        }
        return cnt;
    }
}