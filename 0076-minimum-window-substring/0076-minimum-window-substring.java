
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        int i, j = 0, m = s.length(), n = t.length();
        int need = 0;
        int len = 10000000;
        String ans = "";

        for (i = 0; i < n; i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int cnt=map.size();
        for (i = 0; i < m; i++) {
            char ch=s.charAt(i);
            if(map.containsKey(ch))
            {
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0)
                    cnt--;
            }
            while(j<m && cnt==0)
            {
                if(len>i-j+1)
                {
                    len=i-j+1;
                    ans=s.substring(j,i+1);
                }
                char x=s.charAt(j);
                if(map.containsKey(x))
                {
                    map.put(x,map.get(x)+1);
                    if(map.get(x)>0)
                        cnt++;
                }
                j++;
            }
        }
        return ans;
    }
}
