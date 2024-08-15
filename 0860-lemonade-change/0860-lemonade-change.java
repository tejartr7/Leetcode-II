class Solution {
    public boolean lemonadeChange(int[] bills) {
        int i,j,n=bills.length;
        //Arrays.sort(bills);
        int a=0,b=0,c=0;
        for(int x:bills){
            if(x==5){
                a++;
            }
            else if(x==10){
                if(a>0){
                    a--;
                    b++;
                }
                else return false;
            }
            else{
                if(a>0 && b>0){
                    a--;
                    b--;
                    c++;
                }
                else if(a>=3){
                    a-=3;
                    c++;
                }
                else return false;
            }
        }
        return true;
    }
}