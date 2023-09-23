class Solution {
    TreeMap<Integer,List<String>> map;
   
    public boolean valid(List<String> list,String s)
    {
        if(list.size()==0)
            return true;
        int i=0,m=list.get(list.size()-1).length();
        String temp=list.get(list.size()-1);
        int j=0,n=s.length();
        if(n-m!=1)
            return false;
        while(i<m && j<n)
        {
            if(temp.charAt(i)==s.charAt(j))
            {
                i++;
            }
            j++;
        }
        return i==m;
    }
    public int helper(int idx,List<String> list,String[] words)
    {
        int i,n=words.length;
        //System.out.println(list);
        if(idx>=n)
        {
            return list.size();
        }
       /* if(dp[idx]!=-1)
            return dp[idx];*/
        int x=helper(idx+1,list,words);
        int y=0;
        for(i=idx;i<n;i++)
        {
            if(valid(list,words[i]))
            {
                list.add(words[i]);
                y=Math.max(y,helper(i+1,list,words));
                list.remove(list.size()-1);
            }
        }
      //  if(list.size()>0)
       // dp.put(list.get(0),Math.max(x,y));
        return Math.max(x,y);
    }
    public int longestStrChain(String[] words) {
        int i,j;
        Map<String,Integer> dp=new HashMap<>();
        int n=words.length;
        Arrays.sort(words,(a,b)->a.length()-b.length());
        int res=0;
        for(i=0;i<n;i++)
        {
            String temp=words[i];
            int maxi=0;
            for(j=0;j<temp.length();j++)
            {
                String dummy=temp.substring(0,j)+temp.substring(j+1);
                maxi=Math.max(maxi,dp.getOrDefault(dummy,0)+1);
            }
            dp.put(temp,maxi);
            res=Math.max(res,maxi);
        }
        return res;
    }
}