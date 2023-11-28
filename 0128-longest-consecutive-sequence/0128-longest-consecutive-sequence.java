class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int maxi=1;
        int i=0,j=0,n=nums.length;
        if(n==0) return 0;
        Set<Integer> set=new HashSet<>();
        for(int x:nums)
            set.add(x);
        List<Integer> list=new ArrayList<>();
        for(int x:set)
            list.add(x);
        //System.out.println(list);
        n=list.size();
        Collections.sort(list);
        while(j<n)
        {
            while(i<n && list.get(j)-list.get(i)!=j-i)
            {
                i++;
            }
            if(i<n && list.get(j)-list.get(i)==j-i)
                maxi=Math.max(maxi,j-i+1);
            j++;
        }
        return maxi;
    }
}