class Solution {
    List<String> ans=new ArrayList<>();
    public void helper(int i,String s,List<String> wordDict,List<String> curr){
       if(s.length()==0){
           String temp ="";
           for(int x=0;x<curr.size();x++){
               temp+=curr.get(x);
               if(x!=curr.size()-1)
                   temp+=" ";
           }
           ans.add(temp);
           return ;
       } 
       String temp = s;
        for(int x=i;x<wordDict.size();x++){
        if(s.startsWith(wordDict.get(x))){
            s=s.substring(wordDict.get(x).length());
            curr.add(wordDict.get(x));
            helper(0,s,wordDict,curr);
            s=temp;
            curr.remove(curr.size()-1);
        }
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        helper(0,s,wordDict,new ArrayList<String>());
        return ans;
    }
}