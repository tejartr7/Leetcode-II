class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String temp[]=sentence.split(" ");
        int i,j,n=temp.length;
        for(i=0;i<temp.length;i++){
            if(temp[i].startsWith(searchWord)) return i+1;
        }
        return -1;
    }
}