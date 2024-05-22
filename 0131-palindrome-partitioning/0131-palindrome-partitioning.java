class Solution {
     List<List<String>> l=new ArrayList<>();
    public boolean isPalindrome(String s,int start,int end)
    {
        while(start<end)
        {
            if(s.charAt(start)!=s.charAt(end))
            {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public void backTrack(String s,int start,List<String> list)
    {
       if(s.length()==start)
       {
           l.add(new ArrayList<>(list));
       }
       for(int i=start;i<s.length();i++)
       {
           String temp=s.substring(start,i+1);
           if(isPalindrome(s,start,i))
           {
               list.add(temp);
               backTrack(s,i+1,list);
               list.remove(list.size()-1);
           }
       }
    }
    public List<List<String>> partition(String s) {
        backTrack(s,0,new ArrayList<>());
        return l;
    }
}