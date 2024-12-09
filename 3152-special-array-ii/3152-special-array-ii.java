class pair{
    int x,y;
    pair(int a,int b){
        x=a;
        y=b;
    }
}
class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int i,j,n=nums.length,q=queries.length;
        boolean ans[]=new boolean[q];
        pair temp[]=new pair[n];
        temp[0]=new pair(0,0);
        for(i=0;i<n-1;i++){
            if(nums[i]%2==nums[i+1]%2) {
                temp[i+1]=new pair(1,0);
            }
            else temp[i+1]=new pair(0,1);
            pair prev=temp[i];
            pair curr=temp[i+1];
            temp[i+1]=new pair(prev.x+curr.x,prev.y+curr.y);
        }
        // for(pair x:temp){
        //     System.out.println(x.x+" "+x.y);
        // }
        for(i=0;i<q;i++){
            int x=queries[i][0];
            int y=queries[i][1];
            int p=temp[y].x-temp[x].x;
            int qq=temp[y].y-temp[x].y;
            if(p>0)
                ans[i]=false;
            else ans[i]=true;
            // ans[i]=temp[x]&temp[y];
        }
        return ans;
    }
}