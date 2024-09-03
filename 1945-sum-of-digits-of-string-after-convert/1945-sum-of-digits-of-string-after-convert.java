class Solution {
    public int getLucky(String s, int k) {
        String temp="";
        for(int i=0;i<s.length();i++){
            temp+=(s.charAt(i)-'a'+1);
        }
        int sum=0;
        while(k-->0){
            sum=0;
            for(int i=0;i<temp.length();i++){
                sum+=temp.charAt(i)-'0';
            }
            temp=String.valueOf(sum);
        }
        return sum;
    }
}