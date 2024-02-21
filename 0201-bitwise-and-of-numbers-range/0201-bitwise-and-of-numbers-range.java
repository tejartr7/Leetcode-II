class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        if(left==0)
            return 0;
        int temp=1;
        while(left!=right)
        {
            left/=2;
            right/=2;
            temp*=2;
        }
        return left*temp;
    }
}