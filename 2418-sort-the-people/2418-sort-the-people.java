class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer,String>a=new HashMap<>();
        int i,n=heights.length,j=n-1;
        for(i=0;i<n;i++)
        {
            a.put(heights[i],names[i]);
        }
        String []ans=new String[n];
        Arrays.sort(heights);
        while(j>=0)
        {
            ans[n-1-j]=a.get(heights[j]);
            j--;
        }
        return ans;
        
        
    }
}