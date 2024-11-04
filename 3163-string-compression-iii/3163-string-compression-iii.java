class Solution {
    public String compressedString(String word) {
        StringBuilder ans = new StringBuilder();
        int n = word.length();
        int cnt = 1;
        char ch = word.charAt(0);
        
        for (int i = 1; i < n; i++) {
            if (cnt == 9) {
                ans.append(cnt).append(ch);
                cnt = 1;
                ch = word.charAt(i);
            } else {
                if (ch == word.charAt(i)) {
                    cnt++;
                } else {
                    ans.append(cnt).append(ch);
                    cnt = 1;
                    ch = word.charAt(i);
                }
            }
        }
        
        ans.append(cnt).append(ch);
        return ans.toString();
    }
}
