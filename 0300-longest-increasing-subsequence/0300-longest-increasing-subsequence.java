

class Solution {
    public int bsc(List<Integer> list, int x) {
        int s = 0, e = list.size() - 1;
        while (s <= e) { 
            int m = s + (e - s) / 2; 
            if (list.get(m) < x) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return s;
    }

    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        list.add(nums[0]);
        for (int i = 1; i < n; i++) {
            int x = nums[i];
            if (x > list.get(list.size() - 1)) {
                list.add(x);
            } else {
                int index = bsc(list, x);
                list.set(index, x);
            }
        }
        return list.size();
    }
}
