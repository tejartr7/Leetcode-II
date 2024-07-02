class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
       List<Integer> a=new ArrayList<Integer>();
        int i=0,j=0,l1=nums1.length,l2=nums2.length;
        while(i<l1 && j<l2)
        {
            if(nums1[i]==nums2[j])
            {
                a.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i]<nums2[j])
            {
                i++;
            }
            else
                j++;
        }
        int k=a.size();
        int []b=new int[k];
        int s;
        for(s=0;s<k;s++)
        {
            b[s]=a.get(s);
        }
        return b;
    }
}