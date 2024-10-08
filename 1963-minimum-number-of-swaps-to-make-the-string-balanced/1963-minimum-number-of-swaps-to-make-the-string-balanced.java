class Solution {
    public int minSwaps(String s) {
        int count = 0;
        int min = 0;
        for(char c : s.toCharArray())
        {
            count += c=='[' ? 1 : -1;
            min = Math.min(min,count);
        }
        return (int)(Math.ceil(Math.abs(min)/2.0));
    }
}