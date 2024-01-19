class Trie{
    Trie[] nodes=new Trie[2];
    int cnt=0;
}
class Solution {
    Trie root=new Trie();
    public int maximumStrongPairXor(int[] nums) {
        int i=0,j=0,ans=0,n=nums.length;
        Arrays.sort(nums);
        for(int x:nums)
        {
            while(i<n && nums[i]<=2*x)
                insert(nums[i++]);
            ans=Math.max(ans,max_xor(x));
           // System.out.println(ans);
            delete(x);
        }
        return ans;
    }
    public void insert(int x)
    {
        Trie curr=root;
        int i;
        for(i=20;i>=0;i--)
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
        for(i=20;i>=0;i--)
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

        for (int i = 20; i >= 0; i--) {
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