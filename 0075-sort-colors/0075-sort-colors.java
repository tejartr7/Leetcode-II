class Solution {
    public void sortColors(int[] a ){
       int i,j;
       int temp;
        int l=a.length;
        for(i=0;i<l;i++)
        {
        for(j=i+1;j<l;j++)
        {
            if(a[i]>a[j])
            {
                temp=a[i];
                a[i]=a[j];
                a[j]=temp;
            }
        }
        }
    }
}