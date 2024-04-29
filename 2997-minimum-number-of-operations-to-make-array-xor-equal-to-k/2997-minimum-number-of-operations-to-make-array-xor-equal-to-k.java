class Solution {
    public int minOperations(int[] nums, int k) {
        int xor=0;
        for(int x:nums)
        {
            xor^=x;    
        }
        if(xor==k)
            return 0;
        xor^=k;
        return Integer.bitCount(xor);
    }
}