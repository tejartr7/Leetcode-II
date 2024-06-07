class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        Collections.sort(dict);
        int i,j,m=dict.size();
        String temp[]=sentence.split(" ");
        int n=temp.length;
        boolean vis[]=new boolean[n];
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                if(vis[j]) continue;
                if(temp[j].startsWith(dict.get(i))){
                    vis[j]=true;
                    temp[j]=dict.get(i);
                }
            }
        }
        String ans="";
        for(i=0;i<n;i++){
            ans+=temp[i];
            if(i!=n-1){
                ans+=" ";
            }
        }
        return ans;
    }
}