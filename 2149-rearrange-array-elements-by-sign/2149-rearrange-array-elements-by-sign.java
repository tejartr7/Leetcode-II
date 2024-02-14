class Solution {
    public int[] rearrangeArray(int[] nums) {
       List<Integer> pos=new ArrayList<>();
       List<Integer> neg=new ArrayList<>();
       int i,n=nums.length;
        for(i=0;i<n;i++)
        {
            if(nums[i]<0)
                neg.add(nums[i]);
            else
                pos.add(nums[i]);
        }
        int x=0,y=0;
        int z=0;
        while(z<n)
        {   
            if(z%2==0)
            {nums[z]=pos.get(x);
            x++;}
            if(z%2==1)
            {
                nums[z]=neg.get(y);
                y++;
            }
            z++;
            if(x==pos.size()||y==neg.size())
                break;
        }
        while(x<pos.size())
        {
            nums[z]=pos.get(x);
            x++;
            z++;
        }
        while(y<neg.size())
        {
             nums[z]=neg.get(y);
            y++;
            z++;
        }
        return nums;
    }
    
}