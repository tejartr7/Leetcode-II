class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        sb.append(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            count = (ch == s.charAt(i - 1)) ? count + 1 : 1;
            
            if (count <= 2) {
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }
}
