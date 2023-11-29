class Node{
    Node[] ch=new Node[26];
    boolean end=false;
    boolean containsKey(char c)
    {
        return ch[c-'a']!=null;
    }
    void put(char c)
    {
        ch[c-'a']=new Node();
    }
    boolean getEnd(){
        return end;
    }
    void setEnd(){
        end=true;
    }
    Node get(char c)
    {
        return ch[c-'a'];
    }
}
class Trie {
    Node root;
    public Trie() {
        root=new Node();
    }
    
    public void insert(String word) {
        int i,n=word.length();
        Node curr=root;
        for(i=0;i<n;i++)
        {
            char ch=word.charAt(i);
            if(!curr.containsKey(ch))
            {
                curr.put(ch);
            }
            curr=curr.get(ch);
        }
        curr.setEnd();
    }
    
    public boolean search(String word) {
        int i,n=word.length();
        Node curr=root;
        for(i=0;i<n;i++)
        {
            char ch=word.charAt(i);
            if(!curr.containsKey(ch))
            {
                return false;
            }
            curr=curr.get(ch);
        }
        return curr.getEnd();
    }
    
    public boolean startsWith(String word) {
        int i,n=word.length();
        Node curr=root;
        for(i=0;i<n;i++)
        {
            char ch=word.charAt(i);
            if(!curr.containsKey(ch))
            {
                return false;
            }
            curr=curr.get(ch);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */