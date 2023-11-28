class Solution {
    public int helper1(int[] arr, int s,int e,int i) {
        int ans = 1000000;
        while(s<=e)
        {
            int mid=(s+e)/2;
            if(arr[mid]>=2*arr[i])
            {
                ans=mid;
                e=mid-1;
            }
            else s=mid+1;
        }
        return ans;
    }
    public int helper2(int[] arr, int s,int e,int i) {
        int ans = -1;
        while(s<=e)
        {
            int mid=(s+e)/2;
            if(arr[mid]*2<=(arr[i]+arr[arr.length-1]))
            {
                ans=mid;
                s=mid+1;
            }
            else e=mid-1;
        }
        return ans;
    }
    public int waysToSplit(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        for (int i = 0; i < n; i++) {
            if (i > 0)
                pre[i] += pre[i - 1];
            pre[i] += nums[i];
        }

        int ans = 0;
        int mod = 1000000007;

        for (int i = 0; i < n-2; i++) {
            int l=helper1(pre,i+1,n-2,i);
            int r=helper2(pre,i+1,n-2,i);
            if(r>=l)
                ans=(ans+(r-l+1))%mod;
        }

        return ans;
    }
}
