class MyCalendar {
    List<int[]> list;
    public MyCalendar() {
        list=new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
    int[] temp = new int[]{start, end};
    for (int i = 0; i < list.size(); i++) {
        int[] bookedSlot = list.get(i);
        if (bookedSlot[0] < end && bookedSlot[1] > start) {
            return false;
        }
    }
    list.add(temp);
    return true;
}

}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */