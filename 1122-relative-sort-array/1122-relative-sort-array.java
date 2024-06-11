class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for (int j : arr1) {
            if (hm.containsKey(j)) {
                hm.put(j, hm.get(j) + 1);
            } else {
                hm.put(j, 1);
            }
        }
        int[] ans = new int[arr1.length];
        int cnt=0;
        for (int j : arr2) {
            while (hm.get(j) > 0) {
                ans[cnt] = j;
                cnt++;
                hm.put(j, hm.get(j) - 1);
            }
            hm.remove(j);
        }
        int[] remaining = new int[arr1.length-cnt];
        int index = 0;
        for (int j : arr1) {
            if (hm.containsKey(j)) {
                while (hm.get(j) > 0) {
                    remaining[index] = j;
                    index++;
                    hm.put(j, hm.get(j) - 1);
                }
                hm.remove(j);
            }
        }
        Arrays.sort(remaining);
        for (int j : remaining) {
            ans[cnt] = j;
            cnt++;
        }
        return ans;
    }
}