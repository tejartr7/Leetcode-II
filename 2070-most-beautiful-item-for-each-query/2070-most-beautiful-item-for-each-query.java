class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int i,j,q=queries.length;
        int ans[]=new int[q];
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int x[]:items)
        {
            int a=x[0],b=x[1];
            if(!map.containsKey(a))
                map.put(a,0);
            map.put(a,Math.max(map.get(a),b));
        }
        //System.out.println(map);
        int prev=-1;
        TreeMap<Integer,Integer> temp=new TreeMap<>();
        for(int x:map.keySet())
        {
            if(prev!=-1)
            {
                temp.put(x,Math.max(map.get(x),prev));
            }
            else temp.put(x,map.get(x));
            prev=temp.get(x);
        }
        //System.out.println(temp);
        for(i=0;i<q;i++)
        {
            int x=queries[i];
            
            int y=temp.floorKey(x)==null?-1:temp.floorKey(x);
            //System.out.println(x+" "+y);
            if(y!=-1)
                ans[i]=temp.get(y);
        }
        return ans;
    }
}