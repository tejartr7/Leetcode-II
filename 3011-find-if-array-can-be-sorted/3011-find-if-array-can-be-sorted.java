import java.util.Arrays;

class Solution {
    Boolean[] dp;

    public boolean sorted(int idx, int nums[]) {
        int i, j, n = nums.length;
        boolean sorted = true;

        if (idx >= n - 1) {
            int prev = nums[0];
            for (i = 1; i < n; i++) {
                if (nums[i] < prev) {
                    sorted = false;
                    break;
                }
                prev = nums[i];
            }
            return sorted;
        }

        int prev = nums[0];
        for (i = 1; i < n; i++) {
            if (nums[i] < prev) {
                sorted = false;
                break;
            }
            prev = nums[i];
        }

        if (sorted)
            return sorted;

        
        boolean not = sorted(idx + 1, nums);
        boolean swapped = false;
        int p = Integer.bitCount(nums[idx]);
        int q = Integer.bitCount(nums[idx + 1]);

        if (p == q) {
            if (nums[idx] > nums[idx + 1]) {
                swap(idx, idx + 1, nums);
                swapped |= sorted(0, nums);
                swap(idx, idx + 1, nums);
            }
        }

        dp[idx] = swapped || not;
        return swapped || not;
    }

    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public boolean canSortArray(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        int i,j,n=nums.length;
        int prev=Integer.bitCount(nums[0]);
        List<Integer> curr=new ArrayList<>();
        curr.add(nums[0]);
        for(i=1;i<n;i++)
        {
            int cnt=Integer.bitCount(nums[i]);
            if(cnt!=prev)
            {
                list.add(new ArrayList<>(curr));
                curr.clear();
            }
            curr.add(nums[i]);
            prev=cnt;
        }
        if(curr.size()>0)
            list.add(new ArrayList<>(curr));
        for(i=1;i<list.size();i++)
        {
            int maxi=0,mini=Integer.MAX_VALUE;
            for(int x:list.get(i-1))
                maxi=Math.max(maxi,x);
            for(int x:list.get(i))
                mini=Math.min(mini,x);
            if(maxi>mini)
                return false;
        }
        return true;
    }
}
