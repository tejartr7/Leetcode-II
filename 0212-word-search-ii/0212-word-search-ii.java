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

class Solution {
    Trie trie;
    boolean valid(int i,int j,int m,int n)
    {
        return i>=0 && i<m && j>=0 && j<n;
    }
    void search(int i,int j,char[][] b,Node root,List<String> list,String s)
    {
        int m=b.length,n=b[0].length;
        if(!valid(i,j,m,n) || b[i][j]=='*' || root==null || !root.containsKey(b[i][j]))
            return ;
        s+=b[i][j];
        Node curr=root.get(b[i][j]);
        if(curr.getEnd())
        {
            if(!list.contains(s))
            {
                curr.end=false;
                list.add(s);
            }
        }
        b[i][j]='*';
        search(i+1,j,b,curr,list,s);
        search(i-1,j,b,curr,list,s);
        search(i,j+1,b,curr,list,s);
        search(i,j-1,b,curr,list,s);
        b[i][j]=s.charAt(s.length()-1);
    }
    public List<String> findWords(char[][] board, String[] words) {
        trie=new Trie();
        for(String x:words)
        {
            trie.insert(x);
        }
        int i,j,m=board.length,n=board[0].length;
        List<String> list=new ArrayList<>();
        for(i=0;i<m;i++)
        {
            for(j=0;j<n;j++)
            {
                search(i,j,board,trie.root,list,"");
            }
        }
        return list;
    }
}