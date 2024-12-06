
class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> set=new HashSet<>();
        for(int x:banned)
        {
            set.add(x);
        }
        int i;
        int sum=0;
        int count=0;
        for(i=1;i<=n;i++)
        {
            if(set.contains(i))
            continue;
            else
            {
                sum+=i;
                if(maxSum<sum)
                    break;
                else
                    count++;
            }
        }
        return count;
    }
}