import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] h) {
        int ans = 0;
        int n = h.length;
        Stack<Integer> stack = new Stack<>();
        int s[] = new int[n];
        int e[] = new int[n];
        
        // Calculate 's' array
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && h[stack.peek()] >= h[i]) {
                stack.pop();
            }
            s[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        
        // Clear the stack before reusing it
        stack.clear();
        
        // Calculate 'e' array
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && h[stack.peek()] >= h[i]) {
                stack.pop();
            }
            e[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // Calculate the maximum area
        for (int i = 0; i < n; i++) {
            int x = e[i] - s[i] - 1;
            ans = Math.max(ans, h[i] * x);
        }
        
        return ans;
    }
}
