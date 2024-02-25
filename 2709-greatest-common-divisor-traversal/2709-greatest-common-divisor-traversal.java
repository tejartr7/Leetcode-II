class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        int i,j,n=nums.length;
        Map<Integer,Integer> map=new HashMap<>();
        DSU dsu=new DSU(n+1);
        if(n==1)
            return true;
        for(i=0;i<n;i++)
        {
            int temp=nums[i];
            if(nums[i]==1)
                return false;
            for(int x=2;x*x<=nums[i];x++)
            {
                if(temp%x!=0)
                    continue;
                if(!map.containsKey(x))
                {
                    map.put(x,i);
                }
                else{
                    int val=map.get(x);
                    dsu.merge(val,i);
                    map.put(x,i);
                }
                while(temp%x==0)
                    temp/=x;
            }
            if(temp>1)
            {
                if(!map.containsKey(temp))
                {
                    map.put(temp,i);
                }
                else{
                    int val=map.get(temp);
                    dsu.merge(val,i);
                    map.put(temp,i);
                }
            }
        }
        for(int x:dsu.size)
        {
            if(x==n)
                return true;
        }
        return false;
    }
}
class DSU {
    public int[] dsu;
    public int[] size;

    public DSU(int N) {
        dsu = new int[N + 1];
        size = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            dsu[i] = i;
            size[i] = 1;
        }
    }
    public int find(int x) {
        return dsu[x] == x ? x : (dsu[x] = find(dsu[x]));
    }
    public void merge(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (fx == fy){
            return;
        }
        if (size[fx] > size[fy]) {
            int temp = fx;
            fx = fy;
            fy = temp;
        }
        dsu[fx] = fy;
        size[fy] += size[fx];
    }
}