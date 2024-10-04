class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int n=skill.length;
        int sum=skill[0]+skill[n-1];
        int i=0,j=n-1;
        long pro=0;
        while(i<j)
        {
            int s=skill[i]+skill[j];
            if(s!=sum)
            return -1;
            else
            pro+=(long)(skill[i]*skill[j]);
            i++;
            j--;
        }
        return pro;
    }
}