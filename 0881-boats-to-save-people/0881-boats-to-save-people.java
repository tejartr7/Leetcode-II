class Solution {
    public int numRescueBoats(int[] p, int limit) {
        int l=0,h=p.length-1; 
        Arrays.sort(p);
        int count=0;
        int sum=0;
        while(l<=h)
        {
            if(p[h]+p[l]>limit)
            {
                h--;
                //count++;
            }
            else
            {
                l++;
                h--;
            }
            count++;
        }
        return count;
    }
}