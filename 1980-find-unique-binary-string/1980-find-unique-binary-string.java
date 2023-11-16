class Solution {
    public String findDifferentBinaryString(String[] nums) {
        List<Integer> temp=new ArrayList<>();
        for(String x:nums)
        {
            int val=Integer.parseInt(x,2);
            temp.add(val);
        }
        int cnt=0;
        while(temp.contains(cnt))
        {
            cnt++;
        }
        String ans="";
        ans+=Integer.toBinaryString(cnt);
        int l=nums[0].length();
        ans="0".repeat(l-ans.length())+ans;
        return ans;
    }
}