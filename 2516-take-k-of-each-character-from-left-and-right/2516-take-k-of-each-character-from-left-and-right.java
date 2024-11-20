class Solution {
    public int takeCharacters(String s, int k) {
        int i,j,n=s.length();
        int ans=n;
        int cnt[]=new int[3];
        for(i=0;i<n;i++){
            cnt[s.charAt(i)-'a']++;
        }
        for(i=0;i<=2;i++){
            if(cnt[i]<k) return -1;
        }
        int curr[]=new int[3];
        i=0;
        j=0;
        int maxi=0;
        while(j<n){
            curr[s.charAt(j)-'a']++;
            while(i<=j && (cnt[0]-curr[0]<k || cnt[1]-curr[1]<k ||cnt[2]-curr[2]<k)){
                curr[s.charAt(i)-'a']--;
                i++;
            }
            maxi=Math.max(maxi,j-i+1);
            j++;
        }
        return ans-maxi;
    }
}