import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean judgeSquareSum(int c) {
        int l =0,r=(int)Math.sqrt(c);
        while(l<=r){
            long s = (long) l * l + (long) r * r;
            if(s==c){
                return true;
            }
            else if(s>c){
                r--;
            }
            else l++;
        }
        return false;
    }
}
