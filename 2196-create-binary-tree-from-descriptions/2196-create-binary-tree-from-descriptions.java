 class Solution {
    Map<Integer,int[]> map;
    Map<Integer,Integer> par;
    public TreeNode construct(int x){
        if(x==-1) return null;
        if(!map.containsKey(x)) return new TreeNode(x);
        if(map.get(x)[0]==-1 && map.get(x)[1]==-1) 
            return new TreeNode(x);
        TreeNode root=new TreeNode(x);
        root.left=construct(map.get(x)[0]);
        root.right=construct(map.get(x)[1]);
        return root;
    } 
    public TreeNode createBinaryTree(int[][] arr) {
        int i,j,n=arr.length;
        par=new HashMap<>();
        map=new HashMap<>();
        int t=-1;
        for(i=0;i<n;i++){
            int x=arr[i][0];
            int y=arr[i][1];
            int z=arr[i][2];
            par.put(y,x);
            if(!par.containsKey(x)){
                t=x;
            }
            if(!map.containsKey(x))
                map.put(x,new int[]{-1,-1});
            if(map.containsKey(x)){
                if(z==1){
                    int temp=map.get(x)[1];
                    map.put(x,new int[]{y,temp});
                }
                else{
                    int temp=map.get(x)[0];
                    map.put(x,new int[]{temp,y});
                }
            }
        }
        while(par.containsKey(t)){
            t=par.get(t);
        }
        return construct(t);
    }
}