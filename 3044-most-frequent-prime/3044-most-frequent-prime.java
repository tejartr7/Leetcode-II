class Solution {
    static Map<Integer, Boolean> isPrime = new HashMap<>();
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
    Map<Integer, Integer> primeFreq;
    int maxFreq, maxN;
    
    public int mostFrequentPrime(int[][] mat) {
        primeFreq = new HashMap<>();
        
        for(int i=0; i<mat.length; i++) {
            for(int j=0; j<mat[0].length; j++) {
                for(int[] dir : dirs) {
                    dfs(mat, i, j, 0, dir);
                }
            }
        }
        return maxFreq == 0 ? -1 : maxN;
    }
    
    public void dfs(int[][] mat, int r, int c, int n, int[] dir) {
        if(r < 0 || c < 0 || r >= mat.length || c >= mat[0].length) {
            return;
        }
        
        n = n*10 + mat[r][c]; // Generate number.
        
        if(n > 10 && isPrime(n)) {
            primeFreq.put(n, primeFreq.getOrDefault(n, 0) + 1);
            if(primeFreq.get(n) == maxFreq) { 
                maxN = Math.max(maxN, n); // Update it to largest number
            } else if(primeFreq.get(n) > maxFreq) {
                maxFreq = primeFreq.get(n);
                maxN = n;
            }
        }
        
        int newR = r + dir[0];
        int newC = c + dir[1];
        dfs(mat, newR, newC, n, dir);
        
    }
        
    public boolean isPrime(int n) { 
        if(isPrime.containsKey(n)) {
            return isPrime.get(n);
        }
        if (n <= 1) 
            return false; 
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                isPrime.put(n, false);
                return false;
            }
        }
        isPrime.put(n, true);
        return true; 
    } 
}