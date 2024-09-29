class Solution {
    public boolean check(int[] f1, int[] f2, int left, int right, String s, String pattern){
        int cnt = 0;
        for(int i=0;i<26;i++){
            if(f1[i] != f2[i]){
                if((Math.abs(f1[i] - f2[i]) > 1) || (Math.abs(f1[i] - f2[i]) != 1 && cnt == 2)){
                    return false;
                }
                cnt+=1;
            }
        }
        cnt = 0;
        int start = 0, end = pattern.length()-1;
        while(start <= end){
            if(s.charAt(start+left) != pattern.charAt(start)){
                cnt += 1;
            }
            if(start+left != left+end && s.charAt(left + end) != pattern.charAt(end)){
                cnt +=1;
            }
            if(cnt >= 2) return false;
            start++;
            end--;
        }

        return true;
    }
    public int minStartingIndex(String s, String pattern) {
        int n = s.length(),left = 0, right = 0;
        int[] f1 = new int[26], f2 = new int[26];
        for(char ch : pattern.toCharArray()){
            f2[ch - 'a']++;
        }
        while(right < n){
            char ch = s.charAt(right);
            f1[ch - 'a']++;
            if(right - left + 1 == pattern.length()+1){
                f1[s.charAt(left) - 'a']--;
                left+=1;
            }
            if(right - left + 1 == pattern.length()){
                if(check(f1,f2,left,right,s,pattern) == true){
                    return left;
                }
            }
            right+=1;
        }
        return -1;
    }
}