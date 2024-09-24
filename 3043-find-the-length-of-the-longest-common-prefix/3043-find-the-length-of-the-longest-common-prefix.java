class Trie {
    Trie[] links = new Trie[10];
    Trie get(int x) {
        return links[x];
    }
    void set(int x, Trie node) {
        links[x] = node;
    }
    boolean contains(int x) {
        return links[x] != null;
    }
}

class Solution {
    Trie root;

    public void insert(int[] arr1) {
        root = new Trie();
        for (int i = 0; i < arr1.length; i++) {
            Trie temp = root;
            String s = String.valueOf(arr1[i]);
            for (int j = 0; j < s.length(); j++) {
                int digit = s.charAt(j) - '0';
                if (!temp.contains(digit)) {
                    temp.set(digit, new Trie());
                }
                temp = temp.get(digit);
            }
        }
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        insert(arr1);
        int max = 0;
        for (int i = 0; i < arr2.length; i++) {
            String s = String.valueOf(arr2[i]);
            int cnt = 0;
            Trie temp = root;
            for (int j = 0; j < s.length(); j++) {
                int digit = s.charAt(j) - '0';
                if (temp.contains(digit)) {
                    temp = temp.get(digit);
                    cnt++;
                } else {
                    break;
                }
            }
            max = Math.max(max, cnt);
        }
        return max;
    }
}
