class Solution {
    public boolean unique(String s)
    {
        int i=0;
        Set<Character> set=new HashSet<>();
        for(i=0;i<s.length();i++)
        {
            if(set.contains(s.charAt(i))) return false;
            set.add(s.charAt(i));
        }
        return true;
    }
    public void backTrack(List<String> arr,String str,int dp[],int index)
    {
        if(index>=arr.size()) return ;
        String temp=arr.get(index);
        boolean exists=false;
        String k=str;
        dp[0]=Math.max(dp[0],str.length());
        str+=temp;
        if(!unique(str) || !unique(temp)) exists=true;
        if(!exists)
        {
            dp[0]=Math.max(dp[0],str.length());
            backTrack(arr,str,dp,index+1);
        }
        str=k;
        backTrack(arr,str,dp,index+1);
    }
    public int maxLength(List<String> arr) {
        int dp[]=new int[1];
        dp[0]=0;
        backTrack(arr,"",dp,0);
        return dp[0];
    }
}