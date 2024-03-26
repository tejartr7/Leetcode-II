class Solution {
 public int firstMissingPositive(int[] nums) {
   //  Arrays.sort(nums);
      int i;
       Set<Integer> a=new HashSet<Integer>();
        for(i=0;i<nums.length;i++)
        {
            a.add(nums[i]);
        }
        int j=1;
        while(j<=nums.length+1)
        { if(!a.contains (j))
            return j;
            j++;
        }
        return -1;
    }
}