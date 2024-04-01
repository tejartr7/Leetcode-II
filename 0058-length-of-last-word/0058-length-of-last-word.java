class Solution {
    public int lengthOfLastWord(String s) {
        int count1 = 0;
        int i;
        int l = s.length();
        int count2 = 0;
        int index = l - 1;
        
        while (s.charAt(index) == ' ') {
            index--;
        }
        
        for (i = index; i >= 0; i--) { 
            if (s.charAt(i) != ' ') {
                count1++;
            } else {
                break;
            }
        }
        
        return count1;
    }
}
