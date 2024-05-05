class Solution {
    public int gcdof(int a,int b){
        if(b==0)
            return a;
        return gcdof(b,a%b);
    }
    public int minAnagramLength(String s) {
        int i,j,n=s.length();
        int arr[]=new int[26];
        int gcd=0;
        for(i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            arr[ch-'a']++;
            if(i==n-1)
                gcd=arr[ch-'a'];
        }
        for(i=0;i<26;i++){
            if(arr[i]>0){
                gcd=gcdof(arr[i],gcd);
            }
        }
        return n/gcd;
    }
}