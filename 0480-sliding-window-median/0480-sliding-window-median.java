class Solution {
    public static int binarySearch(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (list.get(mid) == target) {
                return mid; // Element already present
            } else if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left; // Element not present, return the insertion point
    }
   public void addEle(List<Integer> list, int num) {
    int index = binarySearch(list, num);
    System.out.println(index);
    if (index < 0) {
        index = -(index + 1); 
    }
    list.add(index, num);
    }

    public void removeEle(List<Integer> list, int num) {
    int index = Collections.binarySearch(list, num);
        //System.out.println(index);
    if (index >= 0) {
        list.remove(index);
    }
    }

    public double median(List<Integer> list,int k)
    {
        return k % 2 == 0 ? ((double) list.get (k / 2 - 1) + list.get (k / 2)) / 2 : list.get (k / 2);
    }
    public double[] medianSlidingWindow(int[] nums, int k) {
        List<Integer> list=new ArrayList<>();
        int i=0,j=0,n=nums.length;
        double[] ans=new double[n-k+1];
        while(j<n)
        {
            addEle(list,nums[j]);
            if(j-i+1==k)
            {
                ans[i]=median(list,k);
                removeEle(list,nums[i]);
                i++;
            }
            j++;
        }
        return ans;
    }
}