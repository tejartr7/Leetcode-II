import java.util.Stack;

class MyQueue {
    Stack<Integer> a=new Stack<>();
    Stack<Integer> b=new Stack<>();
    int peek=0;
    public MyQueue() {
        
    }
    
    public void push(int x) {
        a.push(x);
    }
    
    public int pop() {
        if(!b.isEmpty())
            return b.pop();
        else
        {
            while(!a.isEmpty())
            {
                b.push(a.pop());
            }
        }
        return b.pop();
    }
    
    public int peek() {
        if(!b.isEmpty())
            return b.peek();
        else
        {
            while(!a.isEmpty())
            {
                b.push(a.pop());
            }
        }
        return b.peek();
    }
    
    public boolean empty() {
        return a.isEmpty() && b.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */