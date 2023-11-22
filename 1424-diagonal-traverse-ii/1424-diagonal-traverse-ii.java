class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> groups = new HashMap();
        int n = 0;
        for (int row = nums.size() - 1; row >= 0; row--) {
            for (int col = 0; col < nums.get(row).size(); col++) {
                int diagonal = row + col;
                if (!groups.containsKey(diagonal)) {
                    groups.put(diagonal, new ArrayList<Integer>());
                }
                
                groups.get(diagonal).add(nums.get(row).get(col));
                n++;
            }
        }
        
        int[] ans = new int[n];
        int i = 0;
        int curr = 0;
        
        while (groups.containsKey(curr)) {
            for (int num : groups.get(curr)) {
                ans[i] = num;
                i++;
            }
            
            curr++;
        }
        
        return ans;
    }
}
