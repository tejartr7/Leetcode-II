class Solution {
    //so we can add things only in starting or ending or middle 
    public boolean validStart(String s1,String s2){
        String temp1[]=s1.split(" ");
        String temp2[]=s2.split(" ");
        int i,j,m=temp1.length,n=temp2.length;
        if(m>n){
            i=m-1;
            j=n-1;
            while(j>=0 && temp1[i].equals(temp2[j])){
                i--;
                j--;
            }
            if(j<0) return true;
            return false;
        }
        else{
            i=m-1;
            j=n-1;
            while(i>=0 && temp1[i].equals(temp2[j])){
                i--;
                j--;
            }
            if(i<0) return true;
            return false;
        }
    }
    public boolean validEnd(String s1,String s2){
        String temp1[]=s1.split(" ");
        String temp2[]=s2.split(" ");
        int i,j,m=temp1.length,n=temp2.length;
        if(m>n){
            i=0;
            j=0;
            while(j<n && temp1[i].equals(temp2[j])){
                i++;
                j++;
            }
            if(j==n) return true;
            return false;
        }
        else{
            i=0;
            j=0;
            while(i<m && temp1[i].equals(temp2[j])){
                i++;
                j++;
            }
            if(i==m) return true;
            return false;
        }
    }
  public boolean validMid(String s1, String s2) {
    String[] temp1 = s1.split(" ");
    String[] temp2 = s2.split(" ");
    int m = temp1.length;
    int n = temp2.length;

    if (m > n) {
        return validMid(s2, s1);
    }

    for (int x = 0; x <= m; x++) {
        boolean prefixMatch = true;
        for (int i = 0; i < x; i++) {
            if (!temp1[i].equals(temp2[i])) {
                prefixMatch = false;
                break;
            }
        }
        if (prefixMatch) {
            int elementsToRemove = n - m;
            if (x + elementsToRemove <= n) {
                boolean suffixMatch = true;
                for (int j = 0; j < m - x; j++) {
                    if (x + j + elementsToRemove >= n || !temp1[x + j].equals(temp2[x + j + elementsToRemove])) {
                        suffixMatch = false;
                        break;
                    }
                }
                if (suffixMatch) {
                    return true;
                }
            }
        }
    }
    return false;
}


    public boolean areSentencesSimilar(String s1, String s2) {
        if(validStart(s1,s2)){
            return true;
        }
        if(validEnd(s1,s2)){
            return true;
        }
        if(validMid(s1,s2)){
            return true;
        }
        return false;
    }
}