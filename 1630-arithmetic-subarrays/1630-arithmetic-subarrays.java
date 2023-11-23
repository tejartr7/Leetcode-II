class Solution {
    
    public boolean valid(int i,int j,int nums[])
    {
        int temp[]=new int[j-i+1];
        int k;
        for(k=i;k<=j;k++)
        {
            temp[k-i]=nums[k];
        }
        Arrays.sort(temp);
        if(temp.length==1)
            return true;
        int diff=temp[1]-temp[0];
        for(k=1;k<temp.length;k++)
        {
            if(diff!=temp[k]-temp[k-1])
                return false;
        }
        return true;
    }
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int i,j,m=nums.length,n=l.length;
        List<Boolean> list=new ArrayList<>();
        for(i=0;i<n;i++)
        {
            if(valid(l[i],r[i],nums))
            {
                list.add(true);
            }
            else list.add(false);
        }
        return list;
    }
}