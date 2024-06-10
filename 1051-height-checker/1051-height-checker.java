class Solution {
    public int heightChecker(int[] h) {
        int l=h.length;
        int a[]=new int[l];
        int i;
        for(i=0;i<l;i++)
            a[i]=h[i];
        Arrays.sort(a);
        int count=0;
        for(i=0;i<l;i++)
        {
            if(a[i]!=h[i])
                count++;
        }
        return count;
    }
}