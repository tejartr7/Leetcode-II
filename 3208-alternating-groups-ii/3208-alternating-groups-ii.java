class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int i,j,n=colors.length;
        int pre[]=new int[n+k-1];
        int ans=0;
        List<Integer> list=new ArrayList<>();
        for(int x:colors) list.add(x);
        for(i=0;i<k-1;i++) list.add(colors[i]);
        //System.out.println(list);
        for(i=0;i<n+k-2;i++){
            if(list.get(i)==list.get(i+1)){
                pre[i]++;
            }
        }
        for(i=1;i<n+k-1;i++) pre[i]+=pre[i-1];
        for(i=0;i<n;i++){
            int diff=0;
            if(i==0){
                diff=pre[i+k-2];
            }
            else{
                diff=pre[i+k-2]-pre[i-1];
            }
            if(diff==0) ans++;
        }
        return ans;
    }
}