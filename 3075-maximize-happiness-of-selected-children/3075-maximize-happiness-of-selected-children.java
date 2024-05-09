class Solution {
    public long maximumHappinessSum(int[] arr, int k) {
        long ans=0;
        int i,j,n=arr.length;
        Arrays.sort(arr);
        int cnt=0;
        i=n-1;
        while(i>=0)
        {
            if(cnt==k)break;
            ans+=Math.max(arr[i]-cnt,0);
            cnt++;
            i--;
        }
        return ans;
    }
}