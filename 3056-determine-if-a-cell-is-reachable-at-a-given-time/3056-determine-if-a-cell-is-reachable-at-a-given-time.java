

class Solution {
    class Pair {
        int r, c;

        Pair(int a, int b) {
            r = a;
            c = b;
        }
    }

    public boolean valid(int i, int j, int m, int n) {
        return i>=1 && i<=m && j>=1 && j<=n;
    }

    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        
        if(sx==fx && sy==fy)
            return t!=1;
        int dx=fx-sx;
        int dy=fy-sy;
        int x1=sx+dx;
        int y1=sy+dx;
        int diff=Math.max(Math.abs(dx),Math.abs(dy));
        if(diff>t)
            return false;
        return true;
    }
}
