class Solution {
    public int minDeletions(String s) {
        char[] ch=s.toCharArray();
        int[] dp=new int[ch.length+1];
        TreeMap<Integer,Integer> map=new TreeMap<>(Collections.reverseOrder());
        int[] a=new int[26];
        for(char x:ch)
        a[x-'a']++;
        int i,j;
        for(i=0;i<26;i++)
        {
            if(a[i]>0)
            {
                map.put(a[i],map.getOrDefault(a[i],0)+1);
            }
        }
        int maxi=map.firstKey();
       // System.out.println(map);
        for(i=maxi-1;i>0;i--)
        {
            if(!map.containsKey(i))
            {
                map.put(i,0);
            }
        }
       // 
        int ans=0;
        for(int x:map.keySet())
        {
            if(x==0)
            break;
            if(map.get(x)<=1)
            continue;
            int val=map.get(x)-1;
            ans+=val;
           // System.out.println(x+" "+ans);
            if(val>0)
            map.put(x-1,map.getOrDefault(x-1,0)+map.get(x)-1);
        }
       // ans+=map.getOrDefault(0,0);
        return ans;
    }
}