class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastOccurrence = new int[26]; // Store the last occurrence index of each character
        boolean[] used = new boolean[26]; // Track whether a character is already in the result
        StringBuilder stack = new StringBuilder(); // Use a stack to build the result
        
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // If the character is already in the result, skip it
            if (used[c - 'a']) {
                continue;
            }
            
            // If the current character is smaller than the last character in the stack
            // and there are more occurrences of the last character later in the string,
            // remove the last character from the stack to maintain the smallest lexicographical order
            while (stack.length() > 0 && c < stack.charAt(stack.length() - 1) &&
                   lastOccurrence[stack.charAt(stack.length() - 1) - 'a'] > i) {
                used[stack.charAt(stack.length() - 1) - 'a'] = false;
                stack.deleteCharAt(stack.length() - 1);
            }
            
            // Add the current character to the stack and mark it as used
            stack.append(c);
            used[c - 'a'] = true;
        }
        
        return stack.toString();
    }
}
