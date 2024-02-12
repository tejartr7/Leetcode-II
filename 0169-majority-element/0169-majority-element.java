class Solution {
    public int majorityElement(int[] a) {
          Map<Integer,Integer> nums=new HashMap<>();
        int i;
        int n=a.length;
        for(i=0;i<n;i++)
        {
            nums.put(a[i],nums.getOrDefault(a[i],0)+1);
        }
        for(int k:nums.keySet())
        {
            if(nums.get(k)>n/2)
            return k;
        }
        return -1;
    }
}