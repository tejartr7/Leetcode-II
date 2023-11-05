class Solution {
    public int getWinner(int[] arr, int k) {
        int i,j,n=arr.length;
        Map<Integer,Integer> map=new HashMap<>();
        int maxi=0;
        for(int x:arr)
            maxi=Math.max(maxi,x);
        if(k>n)
            return maxi;
        List<Integer> list=new ArrayList<>();
        for(int x:arr)
            list.add(x);
        
            i=0;j=0;
            while(i<n)
            {
                j=i+1;
                while(j<n && arr[j]<arr[i])
                    j++;
                if(i>0)
                    map.put(arr[i],1+j-i-1);
                else map.put(arr[i],j-i-1);
               // System.out.println(i+" "+j);
                //System.out.println(arr[i]);
                if(map.get(arr[i])>=k)
                    return arr[i];
                i=j;
            }
        return maxi;
       // return -1;
    }
}