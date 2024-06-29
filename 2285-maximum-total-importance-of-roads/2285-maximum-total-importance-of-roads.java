class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long ans=0;
        long temp=1;
        int indegree[]=new int[n];
        for(int x[]:roads){
            indegree[x[0]]++;
            indegree[x[1]]++;
        }
        Arrays.sort(indegree);
        for(int i=0;i<n;i++){
            ans+=(long)indegree[i]*temp;
            temp++;
        }
        return ans;
    }
}