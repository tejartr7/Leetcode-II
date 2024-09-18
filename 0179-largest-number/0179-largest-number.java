class Solution {
    public String largestNumber(int[] nums) {
        int i,j,n=nums.length;
        // Convert the integer array to a String array for custom sorting
        String[] strNums = new String[n];
        for (i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        // Sort strings based on custom comparator
        Arrays.sort(strNums, (a, b) -> {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1); // Sort in descending order
        });
        String ans="";
        for(String x:strNums)
            ans+=x;
        int idx=0;
        while(idx<ans.length() && ans.charAt(idx)=='0')
            idx++;
        if(idx==ans.length()) 
            return "0";
        return ans.substring(idx);
    }
}