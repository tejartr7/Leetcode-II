class Solution {
    public int maxGoodNumber(int[] nums) {
        String a = Integer.toBinaryString(nums[0]);
        String b = Integer.toBinaryString(nums[1]);
        String c = Integer.toBinaryString(nums[2]);
        
        String concat1 = a + b + c;
        String concat2 = a + c + b;
        String concat3 = b + a + c;
        String concat4 = b + c + a;
        String concat5 = c + a + b;
        String concat6 = c + b + a;
        
        int num1 = Integer.parseInt(concat1, 2);
        int num2 = Integer.parseInt(concat2, 2);
        int num3 = Integer.parseInt(concat3, 2);
        int num4 = Integer.parseInt(concat4, 2);
        int num5 = Integer.parseInt(concat5, 2);
        int num6 = Integer.parseInt(concat6, 2);

        return Math.max(num1, Math.max(num2, Math.max(num3, Math.max(num4, Math.max(num5, num6)))));
    }
}
