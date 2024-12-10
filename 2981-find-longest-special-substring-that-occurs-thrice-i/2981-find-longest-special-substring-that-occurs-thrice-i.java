class Solution {
    public boolean valid(String x)
    {
        int i;
        char ch=x.charAt(0);
        for(i=0;i<x.length();i++)
        {
            if(x.charAt(i)!=ch)
                return false;
        }
        return true;
    }
    public int maximumLength(String s) {
        int i,j,n=s.length();
        Map<String,Integer> map=new HashMap<>();
        for(i=0;i<n;i++){
            for(j=i;j<n;j++)
            {
                String temp=s.substring(i,j+1);
                map.put(temp,map.getOrDefault(temp,0)+1);
            }
        }
        String ans="";
        for(String x:map.keySet())
        {
            if(map.get(x)>=3)
            {
                if(valid(x))
                {
                    if(x.length()>ans.length())
                        ans=x;
                }
            }
        }
        return ans.length()==0?-1:ans.length();
    }
}