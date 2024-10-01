class Solution {
    public boolean canArrange(int[] arr, int k) {
        int i,j,n=arr.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int x:arr){
            map.put((x%k+k)%k,map.getOrDefault((x%k+k)%k,0)+1);
        }
        for(i=0;i<n;i++){
            int x=(arr[i]%k+k)%k;
            if(x==0){
                if(map.get(x)%2==1){
                    return false;
                }
            }
            else if(x==k-x){
                if(map.get(x)%2==1){
                    return false;
                }
            }
            else if(!map.get(x).equals(map.get(k-x))){
                return false;
            }
        }
        return true;
    }
}