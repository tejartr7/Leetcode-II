class Trie{
    Trie []children=new Trie[26];
    int cnt=0;
    boolean contains(int idx){
        return children[idx]!=null;
    }
    Trie get(int idx){
        return children[idx];
    }
    void put(int idx){
        children[idx]=new Trie();
    }
}
class Solution {
    Trie root;
    public void insert(String x){
        int i,j,n=x.length();
        Trie temp=root;
        for(i=0;i<n;i++){
            int ch=x.charAt(i)-'a';
            if(!temp.contains(ch)){
                temp.put(ch);
            }
            temp=temp.get(ch);
            temp.cnt+=1;
        }
    }
    public int[] sumPrefixScores(String[] words) {
        int i,j,n=words.length;
        root=new Trie();
        for(i=0;i<n;i++){
            insert(words[i]);
        }
        int ans[]=new int[n];
        for(i=0;i<n;i++){
            int cnt=0,m=words[i].length();
            Trie temp=root;
            for(j=0;j<m;j++){
                int idx=words[i].charAt(j)-'a';
                if(temp.contains(idx)){
                    temp=temp.get(idx);
                    cnt+=temp.cnt;
                }
                else break;
            }
            ans[i]=cnt;
        }
        return ans;
    }
}