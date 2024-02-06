import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    //private HashMap String;
    public String sortedString(char []c )
    {
        Arrays.sort(c);
        return new String(c);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        int i;
        int j=0;
       int n=strs.length;
       List<List<String>> list=new ArrayList<>();
       Map<String,Integer> map=new HashMap<>();
       for(i=0;i<n;i++)
       {
        String x=sortedString(strs[i].toCharArray());
        if(!map.containsKey(x))
        {
            List<String> temp=new ArrayList<>();
            temp.add(strs[i]);
            map.put(x,j);
            j++;
            list.add(temp);
        }
        else
        {
            list.get(map.get(x)).add(strs[i]);
        }
       }
      return list;
    }
}