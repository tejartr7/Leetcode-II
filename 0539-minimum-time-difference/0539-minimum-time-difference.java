class Solution {
    public int findMinDifference(List<String> arr) {
        int i,j,n=arr.size();
        List<Integer> list=new ArrayList<>();
        for(String x:arr){
            String temp[]=x.split(":");
            int time=Integer.parseInt(temp[0])*60+Integer.parseInt(temp[1]);
            list.add(time);
        }
        int ans=1000_000_000;
        Collections.sort(list);
        for(i=1;i<n;i++){
            ans=Math.min(ans,list.get(i)-list.get(i-1));
            ans=Math.min(ans,1440-list.get(i)+list.get(i-1));
        }
        ans=Math.min(ans,1440-list.get(n-1)+list.get(0));
        return ans;
    }
}