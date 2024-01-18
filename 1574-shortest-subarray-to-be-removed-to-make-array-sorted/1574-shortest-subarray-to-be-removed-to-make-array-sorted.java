class Solution {
    public int finder(int l, int h, int x, int nums[]) {
        int ans = nums.length;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] >=x){
                ans = mid;  
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
    public int findLengthOfShortestSubarray(int[] nums) {
        int n = nums.length;
        int lmax = 0, rmin = n - 1;
        int ans=Integer.MAX_VALUE;
        int prev = nums[0];
        for (int i = 1; i < n; i++) {
            if (prev <=nums[i]) {
                lmax++;
            } else {
                break;
            }
            prev=nums[i];
        }
        if (lmax == n-1) {
            return 0;
        }

        prev = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (prev >=nums[i]) {
                rmin--;
            } else {
                break;
            }
            prev=nums[i];
        }
        for (int i = 0; i <=lmax; i++) {
            int p = finder(rmin, n - 1, nums[i], nums);
            //System.out.println(p);
            ans =Math.min(ans,p-i-1);
        }
        ans=Math.min(ans,rmin);
        ans=Math.min(ans,n-1-lmax);
        return ans==Integer.MAX_VALUE?0:ans;
    }
}