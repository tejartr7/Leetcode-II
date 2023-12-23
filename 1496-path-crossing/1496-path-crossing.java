class Solution {
    public boolean isPathCrossing(String path) {
        Map<Integer,Map<Integer,Integer>> map=new HashMap<>();
        int i,j,n=path.length();
        map.put(0,new HashMap<>());
        map.get(0).put(0,1);
        int x=0,y=0;
        for(i=0;i<n;i++)
        {
            if(path.charAt(i)=='N')
                y++;
            else if(path.charAt(i)=='S')
                y--;
            else if(path.charAt(i)=='E') x++;
            else x--;
            if(!map.containsKey(x))
                map.put(x,new  HashMap<>());
            if(!map.get(x).containsKey(y))
                map.get(x).put(y,0);
            map.get(x).put(y,map.get(x).get(y)+1);
            if(map.get(x).get(y)>1)
                return true;
        }
        return false;
    }
}