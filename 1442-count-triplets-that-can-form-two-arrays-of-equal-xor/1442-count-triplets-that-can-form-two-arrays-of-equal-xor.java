class Solution {
    public int countTriplets(int[] arr) {
        int i,j,k,n=arr.length;
        int ans=0;
        Map<Integer,Map<Integer,Integer>> map=new HashMap<>();
        for(i=0;i<n;i++){
            map.put(i,new HashMap<>());
        }
        for(i=0;i<n;i++){
            int xor=0;
            for(j=i;j<n;j++){
                xor^=arr[j];
                map.get(i).put(j,xor);
            }
        }
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                for(k=0;k<n;k++){
                    if(i<j && j<=k && j-1>=0){
                        int a=map.get(i).getOrDefault(j-1,0);
                        int b=map.get(j).getOrDefault(k,0);
                        if(a==b)
                            ans++;
                    }
                }
            }
        }
        return ans;
    }
}