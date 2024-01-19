class Trie{
    Trie[] nodes=new Trie[2];
    int cnt=0;
}
class tuple{
    int a,b,idx;
    tuple(int x,int y,int z)
    {
        a=x;
        b=y;
        idx=z;
    }
}
class Solution {
    Trie root=new Trie();
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        int i=0,j=0,n=nums.length,q=queries.length;
        int ans[]=new int[q];
        PriorityQueue<tuple> pq=new PriorityQueue<>((a,b)->a.b-b.b);
        Arrays.fill(ans,-1);
        for(i=0;i<q;i++)
        {
            pq.offer(new tuple(queries[i][0],queries[i][1],i));
        }
        while(pq.size()>0)
        {
            tuple top=pq.poll();
            int a=top.a,b=top.b,idx=top.idx;
            while(j<n && nums[j]<=b)
            {
                insert(nums[j++]);
            }
            if(j>0)
            ans[idx]=max_xor(a);
        }
        return ans;
    }
    public void insert(int x)
    {
        Trie curr=root;
        int i;
        for(i=30;i>=0;i--)
        {
            int l=x>>i;
            l%=2;
            if(curr.nodes[l]==null)
                curr.nodes[l]=new Trie();
            curr=curr.nodes[l];
            curr.cnt++;
        }
    }
    public void delete(int x)
    {
        Trie curr=root;
        int i;
        for(i=30;i>=0;i--)
        {
            int l=x>>i;
            l%=2;
            curr=curr.nodes[l];
            curr.cnt--;
        } 
    }
    public int max_xor(int x) {
        Trie curr = root;
        int ans = 0;

        for (int i = 30; i >= 0; i--) {
            int bit = (x >> i) & 1;
            int toggleBit = 1 - bit;
            
            if (curr.nodes[toggleBit] != null && curr.nodes[toggleBit].cnt > 0) {
                ans |= (1 << i);
                curr = curr.nodes[toggleBit];
            } else {
                curr = curr.nodes[bit];
            }
        }
        return ans;
    }
}