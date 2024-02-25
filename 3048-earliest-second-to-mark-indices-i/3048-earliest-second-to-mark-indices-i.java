class pair{
    int pos;
    int idx;
    pair(int a,int b)
    {
        pos=a;
        idx=b;
    }
}
class Solution {
    public int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
        int n = nums.length;
        int m=changeIndices.length;
        int low=0,high=m-1;
        int ans=-1;
        while (low <=high) {
            int mid = (low + high) / 2;
            if (isPossible(nums, changeIndices, mid)){ 
                ans=mid+1;
                high = mid-1;
            }
            else low = mid + 1;
        }
        return ans;
    }

    private boolean isPossible(int[] nums, int[] changeIndices, int s) {
        int n = nums.length;
        int[] last = new int[n];
        Arrays.fill(last, -1);
        for (int i = 0; i <= s; i++) { 
            last[changeIndices[i]-1] = i;
        }
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->a.pos-b.pos);
        for(int i=0;i<n;i++)
        {
            if(last[i]==-1) return false;
            pq.offer(new pair(last[i],i));
        }
        int have=pq.peek().pos;
        pair prev=null;
        while(pq.size()>0){
            pair top=pq.poll();
            int need=nums[top.idx];
            if(prev!=null)
            have+=top.pos-prev.pos-1;
            //System.out.println(have+" "+need);
            if(need>have)
                return false;
            have-=need;
            prev=top;
        }
        return true;
        
    }
}