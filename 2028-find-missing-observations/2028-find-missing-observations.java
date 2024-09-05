class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int i,j,m=rolls.length;
        int sum=0;
        for(int x:rolls) sum+=x;
        int temp=mean*(n+m)-sum;
        if(temp>6*n || temp<=0 || n>temp){
            return new int[0];
        }
        //System.out.println(sum+" "+temp);
        int x[]=new int[n];
        for(i=0;i<n;i++){
            if(temp%n!=0){
                temp--;
                x[i]=temp/n+1;
            }
            else x[i]=temp/n;
        }
        return x;
    }
}