class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        int i,j,n=seats.length;
        int ans=0;
        Arrays.sort(seats);
        Arrays.sort(students);
        for(i=0;i<n;i++){
            ans+=Math.abs(seats[i]-students[i]);
        }
        return ans;
    }
}