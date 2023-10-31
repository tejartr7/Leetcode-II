class Solution {
    public int[] findArray(int[] pref) {
        int n=pref.length;
        int i;
        if(n<=1)
            return pref;
        int ans[]=new int[n];
        ans[0]=pref[0];
        int xor=ans[0];
        for(i=1;i<n;i++)
        {   
            ans[i]=xor^pref[i];
            xor^=ans[i];
        }
        return ans;
    }
}