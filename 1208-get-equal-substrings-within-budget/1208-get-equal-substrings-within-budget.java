class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int i,j,n=s.length();
        int maxi=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        int arr[]=new int[n];
        for(i=0;i<n;i++){
            arr[i]=Math.abs(s.charAt(i)-t.charAt(i));
        }
        i=0;
        j=0;
        int sum=0;
        while(j<n){
            sum+=arr[j];
            if(sum<=maxCost){
                maxi=Math.max(maxi,j-i+1);
            }
            while(sum>maxCost){
                sum-=arr[i];
                i++;
            }
            j++;
        }
        return maxi;
    }
}