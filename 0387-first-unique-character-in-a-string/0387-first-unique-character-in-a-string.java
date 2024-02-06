class Solution {
    public int firstUniqChar(String s) {
   HashMap<Character,Integer> a=new HashMap<Character,Integer>();
        int i;
        int l=s.length();
        for(i=0;i<l;i++)
        {
            char c=s.charAt(i);
            a.put(c,a.getOrDefault(c,0)+1);
        }
        for(i=0;i<l;i++)
        {
            if(a.get(s.charAt(i))==1)
                return i;
        }
        return -1;
    }
}