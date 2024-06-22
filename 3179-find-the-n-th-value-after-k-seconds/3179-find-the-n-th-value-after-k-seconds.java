class Solution {
    public int valueAfterKSeconds(int n, int k) {
        long arr[]=new long[n];
        Arrays.fill(arr,1);
        int i,j;
        long sum=0L;
        long mod=1000_000_007L;
        for(i=0;i<k;i++){
            for(j=0;j<n;j++){
                sum=(sum%mod+arr[j]%mod)%mod;
                arr[j]=sum;
            }
            sum=0L;
        }
        return (int)(arr[n-1]%mod);
    }
}