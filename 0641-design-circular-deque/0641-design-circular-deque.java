class MyCircularDeque {
    int size;
    int arr[];
    int n;
    int f=-1,r=-1;
    public MyCircularDeque(int k) {
        arr=new int[k];
        n=k;
    }
    
    public boolean insertFront(int value) {
    if (isFull()) return false;

    if (f == -1) {
        f = r = 0;
        arr[f] = value;
    } else if (f == 0) {
        f = n - 1;
        arr[f] = value;
    } else {
        f--;
        arr[f] = value;
    }
    return true;
    }

    
    public boolean insertLast(int value) {
        if(isFull()) return false;
        if(r==n-1) r=0;
        else r++;
        if(f==-1) f++;
        arr[r]=value;
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty()) return false;
        if(r==f){
            r=f=-1;
        }
        else if(f==n-1){
            f=0;
        }else f++;
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty()) return false;
        if(r==f){
            r=f=-1;
        }
        else if(r==0){
            r=n-1;
        } else
            r--;
        return true;
    }
    
    public int getFront() {
        if(isEmpty()) return -1;
        return arr[f];
    }
    
    public int getRear() {
        if(isEmpty()) return -1;
        return arr[r];
    }
    
    public boolean isEmpty() {
        return f==-1;
    }
    
    public boolean isFull() {
        if(f==r+1) return true;
        return f==0 && r==n-1;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */