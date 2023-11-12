
class Solution {
  
    public void swap(int idx, int[] nums1, int[] nums2) {
        int temp = nums1[idx];
        nums1[idx] = nums2[idx];
        nums2[idx] = temp;
    }
    public boolean valid(int[] nums1,int[] nums2)
    {
        int i,j,n=nums1.length;
        int maxi1=0,maxi2=0;
        for(i=0;i<n;i++)
        {
            if(nums1[i]>nums2[i])
            {
                swap(i,nums1,nums2);
            }
        }
        for (int x : nums1)
            maxi1 = Math.max(maxi1, x);

        for (int x : nums2)
            maxi2 = Math.max(maxi2, x);
        return maxi1==nums1[n-1] && maxi2==nums2[n-1];
    }
    public int helper1(int[]a,int[] b)
    {
        int i,j,n=a.length;
        int maxi=Math.max(a[n-1],b[n-1]);
        int mini=Math.min(a[n-1],b[n-1]);
        int cnt=0;
        for(i=0;i<n-1;i++)
        {
            if(b[i]>mini)
            {
                cnt++;
            }
        }
        if(maxi!=a[n-1])
            cnt++;
        return cnt;
    }
    public int helper2(int[]a,int[] b)
    {
        int i,j,n=a.length;
        int maxi=Math.max(a[n-1],b[n-1]);
        int mini=Math.min(a[n-1],b[n-1]);
        int cnt=0;
        for(i=0;i<n-1;i++)
        {
            if(a[i]>mini)
            {
                cnt++;
            }
        }
        if(maxi!=b[n-1])
            cnt++;
        return cnt;
    }
    public int minOperations(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int maxi1 = 0;
        int maxi2 = 0;

        for (int x : nums1)
            maxi1 = Math.max(maxi1, x);

        for (int x : nums2)
            maxi2 = Math.max(maxi2, x);

        if (nums1[n - 1] == maxi1 && nums2[n - 1] == maxi2)
            return 0;

        int cnt1=0;
        int cnt2=0;
        int []a=new int[n];
        int []b=new int[n];
        
        for(int i=0;i<n;i++)
            a[i]=nums1[i];
        for(int i=0;i<n;i++)
            b[i]=nums2[i];
        
        if(!valid(nums1,nums2))
            return -1;
        
        for(int i=0;i<n;i++)
            nums1[i]=a[i];
        for(int i=0;i<n;i++)
            nums2[i]=b[i];
        
        cnt1=helper1(a,b);
        cnt2=helper2(a,b);
        return Math.min(cnt1,cnt2);
    }
}
