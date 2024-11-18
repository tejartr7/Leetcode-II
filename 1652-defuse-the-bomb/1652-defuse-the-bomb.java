class Solution {
    public int[] decrypt(int[] code, int k) {
        int i,j,cnt=k,n=code.length;
        int res[]=new int[n];
        if(k==0){
            return new int[n];
        }
        if(k>0){
            int sum=0;
            for(i=0;i<n;i++){
                j=i+1;
                sum=0;
                cnt=k;
                while(cnt>0){
                    cnt--;
                    if(j==n){
                        j=0;
                    }
                    sum+=code[j];
                    j++;
                }
                res[i]=sum;
            }
        }
        else{
            int sum=0;
            for(i=0;i<n;i++){
                j=i-1;
                cnt=-1*k;
                sum=0;
                while(cnt>0){
                    cnt--;
                    if(j==-1){
                        j=n-1;
                    }
                    sum+=code[j];
                    j--;
                }
                res[i]=sum;
            }
        }
        return res;
    }
}