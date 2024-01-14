class Solution {
    public boolean closeStrings(String word1, String word2) {
        int i,j,m=word1.length(),n=word2.length();
        if(m!=n)
            return false;
        int arr[]=new int[26];
        int brr[]=new int[26];
        for(i=0;i<m;i++)
        {
            arr[word1.charAt(i)-'a']++;
        }
        for(i=0;i<n;i++)
        {
            brr[word2.charAt(i)-'a']++;
        }
        for(i=0;i<26;i++)
        {
            if(arr[i]>0 && brr[i]==0)
                return false;
            if(arr[i]==0 && brr[i]>0)
                return false;
        }
        Map<Integer,Integer> map=new HashMap<>();
        for(i=0;i<26;i++)
        {
            int x=arr[i];
            if(x==0)
                continue;
            if(!map.containsKey(x))
                map.put(x,0);
            map.put(x,map.get(x)+1);
        }
        for(i=0;i<26;i++)
        {
            int x=brr[i];
            if(x==0)
                continue;
            if(!map.containsKey(x))
                map.put(x,0);
            map.put(x,map.get(x)-1);
        }
        for(int x:map.keySet())
        {
            if(map.get(x)!=0)
                return false;
        }
        return true;  
    }
}