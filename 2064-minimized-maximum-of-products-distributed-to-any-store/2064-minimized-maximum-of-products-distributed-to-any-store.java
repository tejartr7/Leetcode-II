class Solution {
    public int minimizedMaximum(int n, int[] arr) {
        int l=1,h=100000;
        int ans=0;
        while(l<h)
        {
            int count=0;
            int mid=l+(h-l)/2;
            int maxi=0;
            for(int x:arr)
            {
                count+=x/mid;
                if(x%mid>0)
                    count++;
            }
            if(count<=n)
            {
                h=mid;
            }
            else
            {
                l=mid+1;
            }
        }
        return l;
    }
}