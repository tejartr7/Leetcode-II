class Solution {
    public int maker(int a[],int p,int q)
    {
        int ans=0;
        for(int x:a)
        {
            if(x<p)
            {
                ans+=x;
            }
            else if(x>q)
            {
                ans+=(x-q);
            }
        }
        return ans;
    }
    public int minimumDeletions(String word, int k) {
        Map<Character,Integer> map=new HashMap<>();
        int i,j,n=word.length();
        for(i=0;i<n;i++)
        {
            char ch=word.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        i=0;
        int arr[]=new int[map.size()];
        for(char x:map.keySet())
        {
           arr[i++]=map.get(x); 
        }
        Arrays.sort(arr);
        int ans=1000_000_000;
        for(i=0;i<arr.length;i++)
        {
            ans=Math.min(ans,maker(arr,arr[i],arr[i]+k));
            ans=Math.min(ans,maker(arr,arr[i]-k,arr[i]));
        }
        return ans;
    }
}