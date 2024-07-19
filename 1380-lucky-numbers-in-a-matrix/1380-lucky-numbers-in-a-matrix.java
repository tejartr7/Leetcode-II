class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        Set<String> set= new HashSet<>();
        List<Integer> list=new ArrayList<>();
        int i,j,m=matrix.length,n=matrix[0].length;
        for(j=0;j<n;j++){
            int maxi=-1;
            int x=-1;
            for(i=0;i<m;i++){
                if(matrix[i][j]>maxi){
                    maxi=matrix[i][j];
                    x=i;
                }
            }
            String s="";
            s=x+" ";
            s+=j;
            set.add(s);
        }
        for(i=0;i<m;i++){
            int mini=1000_000_000,x=-1;
            for(j=0;j<n;j++){
                if(mini>matrix[i][j]){
                    mini=matrix[i][j];
                    x=j;
                }
            }
            String s="";
            s=i+" ";
            s+=x;
            if(set.contains(s)){
                list.add(mini);
            }
        }
        return list;
    }
}