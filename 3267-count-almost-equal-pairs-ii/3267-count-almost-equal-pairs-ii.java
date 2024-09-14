import java.util.Arrays;

class Solution { 
    public int countPairs(int[] nums) {
        int i, j, n = nums.length;
        int cnt = 0;
        for (i = 0; i < n; i++) {
            for (j = i + 1; j < n; j++) {
                if (i != j && valid(nums[i], nums[j])) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public boolean valid(int x, int y) {
        int a[] = helper(x);
        int b[] = helper(y);
        int diff[] = new int[4];
        int idx = 0;
        int cnt = 0;

        for (int i = 0; i < 8; i++) {
            if (a[i] != b[i]) {
                cnt++;
                if (cnt > 4) return false;
                diff[idx++] = i;
            }
        }

        if (cnt == 0) {
            return true;
        } else if (cnt == 2) {
            return a[diff[0]] == b[diff[1]] && a[diff[1]] == b[diff[0]];
        } else if (cnt == 3) {
            int[] p = {a[diff[0]], a[diff[1]], a[diff[2]]};
            int[] q = {b[diff[0]], b[diff[1]], b[diff[2]]};
            Arrays.sort(p);
            Arrays.sort(q);
            return Arrays.equals(p, q);
        } else if (cnt == 4) {
            return (a[diff[0]] == b[diff[1]] && a[diff[1]] == b[diff[0]] && a[diff[2]] == b[diff[3]] && a[diff[3]] == b[diff[2]]) ||
                   (a[diff[0]] == b[diff[2]] && a[diff[2]] == b[diff[0]] && a[diff[1]] == b[diff[3]] && a[diff[3]] == b[diff[1]]) ||
                   (a[diff[0]] == b[diff[3]] && a[diff[3]] == b[diff[0]] && a[diff[1]] == b[diff[2]] && a[diff[2]] == b[diff[1]]);
        }

        return false;
    }

    public int[] helper(int num) {
        int[] cnt = new int[8];
        int i = 0;
        while (num > 0) {
            cnt[i] = num % 10;
            num /= 10;
            i++;
        }
        return cnt;
    }
}
