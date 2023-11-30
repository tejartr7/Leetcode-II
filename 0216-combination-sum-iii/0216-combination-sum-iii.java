class Solution {
    List<List<Integer>>ans;
    public void helper(int idx,int k,int n,List<Integer> list)
    {
        if(k==0)
        {
            if(n==0)
            {
                ans.add(new ArrayList<>(list));
            }
            return ;
        }
        if(n==0)
        {
            if(k==0)
            ans.add(new ArrayList<>(list));
            return ;
        }
        for(int i=idx;i<=9;i++)
        {
            //System.out.println(list);
            if(list.size()>0 && list.get(list.size()-1)>=i)
                continue;
            list.add(i);
            helper(idx+1,k-1,n-i,list);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        ans=new ArrayList<>();
        helper(1,k,n,new ArrayList<>());
        return ans;
    }
}