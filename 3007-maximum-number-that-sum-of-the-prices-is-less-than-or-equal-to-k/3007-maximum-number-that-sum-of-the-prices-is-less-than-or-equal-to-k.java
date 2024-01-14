class Solution {
    public long findMaximumNumber(long k, int x) {
        long st=0;
        long end=(long)1e18;
        long ans=0;
        while(st<=end){
            long mid=(st+end)/2;
            long cnt=0;
            for(long j=0;j<=60;j++){
                if((j+1)%x==0){
                     long one=1;
                     long no=(one<<(j+1));
                     long pack=(mid+1)/no;
                     cnt+=pack*(no/2);
                     if(cnt>=1e15){
                         break;
                     }
                     cnt+=Math.max((long)0,((mid+1)%no)-no/2);
                     if(cnt>=(long)1e15){
                         break;
                     }
                }
            }
            if(cnt<=k){
                st=mid+1;
                ans=Math.max(ans,mid);
            }else{
               end=mid-1;
            }
        }
        return ans;
    }
}