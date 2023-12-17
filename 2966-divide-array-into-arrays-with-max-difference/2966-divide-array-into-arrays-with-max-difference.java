class Solution {
    public boolean valid(int i,int []nums,int k)
    {
        int a=nums[i],b=nums[i+1],c=nums[i+2];
        int x=Math.abs(a-b);
        int y=Math.abs(c-b);
        int z=Math.abs(a-c);
        return x<=k && y<=k && z<=k;
    }
    public int[][] divideArray(int[] nums, int k) {
        int i,j,n=nums.length;
        int [][]ans=new int[n/3][3];
        Arrays.sort(nums);
        if(n%3!=0)
            return ans;
        int cnt=0;
        for(i=0;i<n;i+=3)
        {
            //System.out.println(i);
            
            if(valid(i,nums,k))
            {
                int temp[]=new int[3];
                temp[0]=nums[i];
                temp[1]=nums[i+1];
                temp[2]=nums[i+2];
                ans[cnt++]=temp;
            }
            else return new int[][]{};
        }
        return ans;
    }
}