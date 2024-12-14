class Solution {
    public long continuousSubarrays(int[] nums) {
        long res=0;
        int i=0,j=0,n=nums.length;
        PriorityQueue<Integer> max=new PriorityQueue<Integer>(Collections.reverseOrder());
        PriorityQueue<Integer> min=new PriorityQueue<Integer>();
        while(j<n)
        {
            min.offer(nums[j]);
            max.offer(nums[j]);
            while(min.size()>0 && max.peek()-min.peek()>2)
            {
                min.remove(nums[i]);
                max.remove(nums[i]);
                i++;
            }
            res+=j-i+1;
            j++;
        }
        return res;
    }
}