class Solution {
    public boolean check(int arr[],int prev,int max)
    {
        int i=prev+1;
        Set<Integer> set=new HashSet<>();
        for(i=0;i<=max;i++)
        {
            set.add(arr[i]);
        }
        for(i=0;i<=max;i++)
        {
            if(!set.contains(i))
                return false;
        }
        return true;
    }
    public int maxChunksToSorted(int[] arr) {
        int count=0;
        int prev=-1;
        int i=1,j,n=arr.length;
        int maxi=0;
        Set<Integer> set=new HashSet<>();
        int start=0;
        for(i=0;i<n;i++)
        {
            if(check(arr,prev,i))
            {
                count++;
                prev=i;
            }
        }
        return count;
    }
}