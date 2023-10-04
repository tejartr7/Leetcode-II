class MyHashMap {
    int a[];
    public MyHashMap() {
        a=new int[1000001];
        Arrays.fill(a,-1);
    }
    
    public void put(int key, int value) {
        a[key]=value;
    }
    
    public int get(int key) {
        int k=a[key];
       
        return k;
    }
    
    public void remove(int key) {
         a[key]=-1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */