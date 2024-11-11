class Solution {
    public boolean primeSubOperation(int[] nums) {
        int n = nums.length;
        TreeSet<Integer> primes = new TreeSet<>();
        
        boolean[] isPrime = new boolean[1001];
        for (int i = 2; i <= 1000; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i <= 1000; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= 1000; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for (int i = 2; i <= 1000; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) continue;
            int diff = nums[i] - nums[i+1];
            Integer temp = primes.ceiling(diff + 1);
            if (temp == null || temp >= nums[i]) return false;
            nums[i] -= temp;
        }
        
        return true;
    }
}
