class Solution {
    public int maxOperations(String s) {
        int i,j,n=s.length();
        List<Integer> list = new ArrayList<>();
        int cnt=0,idx=-1;
        for(i=n-1;i>=0;i--){
            if(s.charAt(i)=='0'){
                idx=i;
                break;
            }
        }
        if(i<=0) return 0;
        for(i=0;i<=idx;i++){
            char ch=s.charAt(i);
            if(ch=='0'){
                if(cnt>0){
                    list.add(cnt);
                    cnt=0;
                }
            }
            else cnt++;
        }
        int ans=0;
        int temp=0;
        for(int x:list){
            temp+=x;
            ans+=temp;
        }
        return ans;
    }
}