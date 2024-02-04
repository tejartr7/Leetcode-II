import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        int i, j = 0, m = s.length(), n = t.length();
        int need = 0;
        int len = 10000000;
        String ans = "";

        for (i = 0; i < n; i++) {
            map1.put(t.charAt(i), map1.getOrDefault(t.charAt(i), 0) + 1);
        }
        int cnt=map1.size();
        for (i = 0; i < m; i++) {
            char ch=s.charAt(i);
            if(map1.containsKey(ch))
            {
                map1.put(ch,map1.get(ch)-1);
                if(map1.get(ch)==0)
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
                if(map1.containsKey(x))
                {
                    map1.put(x,map1.get(x)+1);
                    if(map1.get(x)>0)
                        cnt++;
                }
                j++;
            }
        }
        return ans;
    }
}
