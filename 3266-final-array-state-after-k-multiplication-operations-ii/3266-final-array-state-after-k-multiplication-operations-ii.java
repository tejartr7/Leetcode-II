class Solution {
    final int mod = 1_000_000_007;
    
    long modpow(long base, int exp) {
        long result = 1;
        while (exp > 0) {
            if (exp % 2 != 0) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }
        return result;
    }

    class Pair {
        int x, y;
        Pair(int a, int b) {
            x = a;
            y = b;
        }
    }

    public int[] getFinalState(int[] nums, int k, int mul) {
        int n = nums.length;
        int maxi = 0;
        if(mul==1) return nums;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) ->a.x!=b.x? a.x - b.x:a.y-b.y);
        for (int i = 0; i < n; i++) {
            maxi = Math.max(nums[i], maxi);
            pq.offer(new Pair(nums[i], i));
        }

        while (k > 0 && (long) mul * pq.peek().x <= maxi) {
            k--;
            Pair top = pq.poll();
            pq.offer(new Pair((int) ((long) top.x * mul % mod), top.y));
        }

        long pow = modpow(mul, k / n);
        int remainingK = k % n;
        while (!pq.isEmpty()) {
            Pair top = pq.poll();
            if (remainingK > 0) {
                remainingK--;
                nums[top.y] = (int) (((long) top.x * mul % mod) * pow % mod);
            } else {
                nums[top.y] = (int) ((long) top.x * pow % mod);
            }
        }

        return nums;
    }
}
