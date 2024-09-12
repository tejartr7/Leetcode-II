class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int ans=0;
        int i,j,m=allowed.length(),n=words.length;
        int arr[]=new int[26];
        for(i=0;i<m;i++){
            arr[allowed.charAt(i)-'a']++;
        }
        for(i=0;i<n;i++){
            String str=words[i];
            boolean valid=true;
            for(j=0;j<str.length();j++){
                if(arr[str.charAt(j)-'a']==0){
                    valid=false;
                    break;
                }
            }
            if(valid)ans++;
        }
        return ans;
    }
}