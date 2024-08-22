class Solution {
    public boolean valid(char num[])
    {
        int n = num.length, gSum=0;
        if (n == 0)
            return true;
    
        if (n % 3 == 1) {
            String temp="00" + new String(num);
            num=temp.toCharArray();
            n += 2;
        }
        else if (n % 3 == 2) {
            String temp="0" + new String(num);
            num=temp.toCharArray();
            n++;
        }
    
        int i, GSum = 0, p = 1;
        for (i = n - 1; i >= 0; i--) {
    
            int group = 0;
            group += num[i--] - '0';
            group += (num[i--] - '0') * 10;
            group += (num[i] - '0') * 100;
    
            gSum = gSum + group * p;
    
            p *= (-1);
        }
    
        return (gSum % 7 == 0);
    }
    public String largestPalindrome(int n, int k) {
       char ch[]=new char[n];
        int i,j;
       if(n==1){
        if(k==1 || k==3 || k==9){
            return "9";
        }
        if(k==2 || k==4 || k==8){
            return "8";
        }
        if(k==5 || k==6 || k==7){
            return String.valueOf(k);
        }
       }
       if(n==2){
        if(k==1 || k==3 || k==9){
            return "99";
        }
        if(k==2 || k==4 || k==8){
            return "88";
        }
        if(k==5 || k==6 || k==7){
            return String.valueOf(k)+String.valueOf(k);
        }
       }
       if(n==3){
        if(k==1 || k==3 || k==9){
            return "999";
        }
        if(k==2){
            return "898";
        }
        if(k==4 || k==8 || k==6){
            return "888";
        }
        if(k==5 ){
            return String.valueOf(k)+"9"+String.valueOf(k);
        }
        if(k==7){
            return "959";  
        }
       }
       for(i=0;i<n;i++){
        ch[i]='9';
       }
       if(k==1 || k==3 || k==9) return new String(ch);
       if(k==2){
            ch[0]=ch[n-1]='8';
            return new String(ch);
       }
       if(k==4){
            ch[0]=ch[1]=ch[n-2]=ch[n-1]='8';
            return new String(ch);
       }
       if(k==5){
            ch[0]=ch[n-1]='5';
            return new String(ch);
       }
       if(k==8){
            ch[0]=ch[1]=ch[2]=ch[n-3]=ch[n-2]=ch[n-1]='8';
            return new String(ch);
       }
       if(k==6){
        ch[0]=ch[n-1]='8';
        int sum=9*n;
        sum-=2;
        if(sum%3==0) return new String(ch);
        if(n%2==0){
            ch[n/2-1]=ch[n/2]='7';
            return new String(ch);
        }
        else {
            ch[n/2]='8';
            return new String(ch);
        }
       }
       if(k==7){
            if(valid(ch)){
                return new String(ch);
            }
            if(n%2==0){
                while(!valid(ch)){
                    ch[n/2-1]=ch[n/2]=(char)(ch[n/2]-'1'+'0');
                }
                return new String(ch);
            }
            while(!valid(ch)){
                ch[n/2]=(char)(ch[n/2]-'1'+'0');
            }
            return new String(ch);
       }
       return "";
    }
}