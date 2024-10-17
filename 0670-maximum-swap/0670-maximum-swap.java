class Solution {
    public void swap(int i,int j,char ch[]){
        char temp=ch[i];
        ch[i]=ch[j];
        ch[j]=temp;
    }
    public int maximumSwap(int num) {
        String temp=String.valueOf(num);
        char ch[]=temp.toCharArray();
        int i,j,n=ch.length;
        int maxi=num;
        for(i=0;i<n;i++){
            for(j=i+1;j<n;j++){
                if(i!=j){
                    swap(i,j,ch);
                    maxi=Math.max(maxi,Integer.parseInt(new String
(ch)));
                    swap(i,j,ch);
                }
            }
        }
        return maxi;
    }
}