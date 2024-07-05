class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] ans = new int[]{-1, -1};
        if (head == null || head.next == null || head.next.next == null) return ans;

        int cnt = 1, p = -1, f = -1, minDist = Integer.MAX_VALUE;
        ListNode prev = head, curr = head.next;

        while (curr.next != null) {
            if ((curr.val > prev.val && curr.val > curr.next.val) || (curr.val < prev.val && curr.val < curr.next.val)) {
                if (f == -1) f = cnt;
                if (p != -1) minDist = Math.min(minDist, cnt - p);
                p = cnt;
            }
            prev = curr;
            curr = curr.next;
            cnt++;
        }

        if (p != f) {
            ans[0] = minDist;
            ans[1] = p - f;
        }
        return ans;
    }
}
