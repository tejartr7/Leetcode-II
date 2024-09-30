public class CustomStack {
    int[] a; // Array to store stack elements
    int count = 0, size = 0; // Track number of elements and max size

    // Constructor to initialize stack with given maxSize
    public CustomStack(int maxSize) {
        a = new int[maxSize];
        size = maxSize;
    }
    
    // Push element x to stack if it's not full
    public void push(int x) {
        if (count < size) a[count++] = x;
    }

    // Pop top element from stack and return it, or return -1 if empty
    public int pop() {
        return count > 0 ? a[--count] : -1;
    }

    // Increment bottom k elements by val
    public void increment(int k, int val) {
        for (int i = 0; i < Math.min(k, count); i++) a[i] += val;
    }
}
