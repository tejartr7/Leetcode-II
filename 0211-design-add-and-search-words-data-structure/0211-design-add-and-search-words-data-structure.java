class Node {
    Node[] ch = new Node[26];
    boolean end = false;

    boolean containsKey(char c) {
        return ch[c - 'a'] != null;
    }

    void put(char c) {
        if (!containsKey(c)) {
            ch[c - 'a'] = new Node();
        }
    }

    boolean getEnd() {
        return end;
    }

    void setEnd() {
        end = true;
    }

    Node get(char c) {
        return ch[c - 'a'];
    }
}

class WordDictionary {
    Node root = new Node();

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        int n = word.length();
        Node curr = root;
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            if (!curr.containsKey(ch)) {
                curr.put(ch);
            }
            curr = curr.get(ch);
        }
        curr.setEnd();
    }

    public boolean search(String word) {
        return helper(0, word, root);
    }

    public boolean helper(int idx, String word, Node root) {
        if (idx >= word.length())
            return root.getEnd();

        char currentChar = word.charAt(idx);

        if (currentChar == '.') {
            for (Node x : root.ch) {
                if (x != null && helper(idx + 1, word, x))
                    return true;
            }
        } else {
            if (!root.containsKey(currentChar))
                return false;

            return helper(idx + 1, word, root.get(currentChar));
        }

        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such: WordDictionary obj = new WordDictionary();
 * obj.addWord(word); boolean param_2 = obj.search(word);
 */
