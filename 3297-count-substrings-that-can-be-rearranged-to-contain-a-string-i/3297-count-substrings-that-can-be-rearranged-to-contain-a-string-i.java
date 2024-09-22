class Solution {
    public long validSubstringCount(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        long ans = 0;
        
        // Frequency arrays to store character counts
        int[] arr = new int[26];
        int[] brr = new int[26];
        
        // Fill arr with character counts of word2
        for (int i = 0; i < n; i++) {
            arr[word2.charAt(i) - 'a']++;
        }

        int i = 0; // Left pointer for sliding window
        
        // Traverse word1 with right pointer j
        for (int j = 0; j < m; j++) {
            brr[word1.charAt(j) - 'a']++; // Include the current character in the window
            
            // Check if the current window is valid
            boolean isValid = true;
            for (int x = 0; x < 26; x++) {
                if (brr[x] < arr[x]) { // If any character count in the window is less than needed
                    isValid = false;
                    break;
                }
            }
            
            // Shrink the window from the left if valid
            while (isValid && i <= j) {
                ans += (m - j); // All substrings starting from i to j are valid
                
                // Shrink window by removing the character at the left
                brr[word1.charAt(i) - 'a']--;
                
                // Check if the window is still valid
                for (int x = 0; x < 26; x++) {
                    if (brr[x] < arr[x]) {
                        isValid = false;
                        break;
                    }
                }
                
                i++; // Move left pointer to the right
            }
        }
        
        return ans;
    }
}
