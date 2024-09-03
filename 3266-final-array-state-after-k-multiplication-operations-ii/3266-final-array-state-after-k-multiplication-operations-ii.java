class Solution {
    
    int mod = 1_000_000_007;
    
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        
        if (multiplier == 1)
            return nums;
        
       PriorityQueue<int []> queue = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        
        for (int i = 0; i < nums.length; ++i) {
            queue.add(new int [] {nums[i], i});
        }
        
        int max = 0;
        
        for (int num : nums) {
            max = Math.max(max, num);
        }
        
        long val;
        
        int [] cur;
        
        while (k > 0 && max / queue.peek()[0] >= multiplier) {
           
            cur = queue.poll();
           
            cur[0] *= multiplier;
            nums[cur[1]] = cur[0];
            queue.add(cur);
            --k;
        }
        
        int times = k / nums.length;
        int rem = k % nums.length;
        
        int [] result = new int [nums.length];
        
        long first = powerSum(multiplier, times, mod);
        long second = powerSum(multiplier, times + 1, mod);
        
        
        //System.out.println(k);
        
        
        while (!queue.isEmpty()) {
            
            cur = queue.poll();
            //System.out.println(Arrays.toString(cur));
            
            val = rem-- > 0 ? second : first;
            val *= cur[0];
            val %= mod;
            
            result[cur[1]] = (int)val;
        }
        
        return result;
    }
    
    private long powerSum(long a, long b, int mod) {
		Map<Long, Long> map = new HashMap<>();
		
		long current = 1;
		long val = a;
		long result = 1;
		
		while (current <= b) {
			map.put(current, val);
			
			val = val * val;
			val %= mod;
			
			current *= 2;
		}
		
		while (current > 1) {
			current /= 2;
			
			if (b >= current) {
				b -= current;
				result *= map.get(current);
				result %= mod;
			}
		}
		
		return result;
	}
}