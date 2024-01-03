class Solution {
    public int numberOfBeams(String[] bank) {
        int cnt=0,prev=0,ans=0,val=0;
        int i,j,m=bank.length,n=bank[0].length();
        for(i=0;i<m;i++)
        {
            int temp=0;
            for(j=0;j<n;j++){
                if(bank[i].charAt(j)=='1')
                {
                    temp++;
                }
            }
            if(temp>0)
            {
                ans+=temp*prev;
                prev=temp;
            }
        }
        return ans;
    }
}