class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public void backTrack(int c[],int sum,int index,List<Integer> l)
    {
      if(sum<0)
      return ;
      if(sum==0)
      {list.add(new ArrayList<>(l));
      return ;
      }
      else
      {
          for(int i=index;i<c.length;i++)
          {
              if(i>index && c[i]==c[i-1])
              continue;
              l.add(c[i]);
              backTrack(c,sum-c[i],i+1,l);
              l.remove(l.size()-1);
          }
      }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> tempList=new ArrayList<>();
        backTrack(candidates,target,0,tempList);
        return list;
    }
}