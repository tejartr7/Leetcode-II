class Solution {
public:
    int findComplement(int num) {
        int ans=0;
        int cnt=0;
        while(num>0){
            if(num%2==0){
                ans+=(1<<cnt);
            }
            num/=2;
            cnt++;
        }
        return ans;
    }
};