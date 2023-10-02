class Solution {
    public boolean winnerOfGame(String s) {
        int i,j;
        int n=s.length();
        int acnt=0,bcnt=0;
        i=0;
        while(i<n)
        {
            int cnt=0;
            if(s.charAt(i)=='A')
            {   
                while(i<n && s.charAt(i)=='A')
                {
                    cnt++;
                    i++;
                }
                if(cnt>=2)
                    acnt+=cnt-2;
            }
            else
            {
                while(i<n && s.charAt(i)=='B')
                {
                    cnt++;
                    i++;
                }
                if(cnt>=2)
                    bcnt+=cnt-2;
            }
        }
        return acnt>bcnt;
    }
}