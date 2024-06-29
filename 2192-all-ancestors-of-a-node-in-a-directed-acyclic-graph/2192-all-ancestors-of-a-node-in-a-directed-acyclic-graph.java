class Solution {
   
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        Map<Integer,List<Integer>> map=new HashMap<>();
        int i;
        for(i=0;i<n;i++)
            map.put(i,new ArrayList<>());
        int l=edges.length;
        int indegree[]=new int[n];
        for(i=0;i<l;i++)
        {
            map.get(edges[i][0]).add(edges[i][1]);
            indegree[edges[i][1]]++;
        }
        //System.out.println(map);
        Queue<Integer> q=new LinkedList<>();
        List<Set<Integer>> list=new ArrayList<>();
        List<List<Integer>> temp=new ArrayList<>();
        for(i=0;i<n;i++)
        {
            list.add(i,new HashSet<>());
            temp.add(i,new ArrayList<>());
            if(indegree[i]==0)
                q.offer(i);
        }
        while(!q.isEmpty())
        {
            int parent=q.poll();
            if(!map.containsKey(parent))
                continue;
            for(int x:map.get(parent))
            {
                list.get(x).add(parent);
                list.get(x).addAll(list.get(parent));
                indegree[x]--;
                if(indegree[x]==0)
                    q.offer(x);
            }
        }
        for(i=0;i<n;i++)
        {
            if(list.get(i).size()==0)
                continue;
            else
            {
                for(int x:list.get(i))
                {
                    if(!temp.get(i).contains(x))
                        temp.get(i).add(x);
                }
                Collections.sort(temp.get(i));
            }
        }
        return temp;
    }
}