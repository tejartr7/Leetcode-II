class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<String> str=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        for(int i=1;i<=n;i++){
            str.add(String.valueOf(i));
        }
        Collections.sort(str);
        for(String x:str){
            ans.add(Integer.parseInt(x));
        }
        return ans;
    }
}