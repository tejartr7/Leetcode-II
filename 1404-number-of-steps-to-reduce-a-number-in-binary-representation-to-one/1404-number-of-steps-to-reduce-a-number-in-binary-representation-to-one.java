class Solution {
    public int numSteps(String s) {
        int c=0;
        int i,j,n=s.length();
        int ans=0;
        i=n-1;
        while(i>=0 || c>0){
            int sum=c;
            if(i>=0)
            sum+=(s.charAt(i)-'0');
            if(i<=0 && sum==1) return ans;
            if(sum==0) {
                c=0;
                ans++;
            }
            else if(sum==1){
                c=1;
                ans+=2;
            }
            else if(sum==2){
                c=1;
                ans++;
            }
            i--;
        }
        return ans;
    }
}