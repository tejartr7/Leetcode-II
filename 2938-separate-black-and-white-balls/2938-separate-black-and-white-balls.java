class Solution {
    public void swap(int i,int j,char ch[])
    {
        char temp=ch[i];
        ch[i]=ch[j];
        ch[j]=temp;
    }
    public long minimumSteps(String s) {
        long ans=0;
        int i,n=s.length();
        char ch[]=s.toCharArray();
        int prev=n;
        for(i=n-1;i>=0;i--)
        {
            if(ch[i]=='1' && prev!=n)
            {
                ans+=prev-i;
                swap(i,prev,ch);
                prev=prev-1;
            }
            else if(ch[i]=='0' && prev==n)
            {
                prev=i;
            }
        }
        return ans;
    }
}