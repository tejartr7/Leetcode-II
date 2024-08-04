class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int i,j;
        List<Integer> list=new ArrayList<>();
        int sum=0;
        for(i=0;i<n;i++){
            int x=0;
            for(j=i;j<n;j++){
                x+=nums[j];
                list.add(x);
            }
        }
        Collections.sort(list);
        long ans=0;
        long mod=1000_000_007;
        for(i=left-1;i<right;i++){
            ans=(ans+list.get(i))%mod;
        }
        return (int)(ans%mod);
    }
}