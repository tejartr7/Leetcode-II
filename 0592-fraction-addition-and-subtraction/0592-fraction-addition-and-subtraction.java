class Solution {
    public int findLCM(List<Integer> numbers) {
        int lcm = numbers.get(0);

        for (int i = 1; i < numbers.size(); i++) {
            lcm = lcm(lcm, numbers.get(i));
        }

        return lcm;
    }

    // Helper method to find the LCM of two numbers
    private int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    // Helper method to find the GCD of two numbers
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public String fractionAddition(String s) {
        List<Integer> l1=new ArrayList<>();
        List<Integer> l2=new ArrayList<>();
        int sym=1;
        if(s.charAt(0)!='-'){
            s="+"+s;
        }
        int i,j,n=s.length();
        for(i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='-'){
                sym=-1;
                int x=i+1;
                while(x<n && Character.isDigit(s.charAt(x))){
                    x++;
                }
                // if(x==n-1)x++;
                String temp=s.substring(i+1,x);
                l1.add(-1*Integer.parseInt(temp));
                i=x-1;
            }
            else if(ch=='+'){
                sym=1;
                int x=i+1;
                while(x<n && Character.isDigit(s.charAt(x))){
                    x++;
                }
                if(x==n-1)x++;
                String temp=s.substring(i+1,x);
                l1.add(Integer.parseInt(temp));
                i=x-1;
            }
            else if(ch=='/'){
                int x=i+1;
                while(x<n && Character.isDigit(s.charAt(x))){
                    x++;
                }
                if(x==n-1)x++;
                String temp=s.substring(i+1,x);
                l2.add(Integer.parseInt(temp));
                i=x-1;
            }
        }
        int x=findLCM(l2);
        int sum=0;
        for(i=0;i<l1.size();i++){
            sum+=((l1.get(i)*x)/l2.get(i));
        }
        int temp=0;
        if(sum>0){
            temp=gcd(sum,x);
        }
        else{
            temp=gcd(-sum,x);
        }
        sum/=temp;
        x/=temp;
        return String.valueOf(sum)+"/"+String.valueOf(x);
    }
}