class Solution:
    def maxLevelSum(self, root: Optional[TreeNode]) -> int:
        q=deque([root])
        m=root.val
        ans=level=1
        if not root:
            return 0;
        while q:
            l=0
            z=len(q)
            for i in range(z):
                n=q.popleft()
                l+=n.val
                if n.left:
                    q.append(n.left)
                if n.right:
                    q.append(n.right)
            if l>m:
                m=l
                ans=level
            level+=1
        return ans