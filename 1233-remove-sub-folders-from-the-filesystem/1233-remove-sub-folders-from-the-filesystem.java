class Solution {
    public List<String> removeSubfolders(String[] folder) {
        List<String> ans=new ArrayList<>();
        int i,j,n=folder.length;
        Set<String> set=new HashSet<>();
        Arrays.sort(folder);
        for(i=0;i<n;i++){
            String curr=folder[i];
            String temp[]=curr.split("/");
            //System.out.println(curr);
            String d="";
            for(j=0;j<temp.length-1;j++){
                if(temp[j].equals("/") || temp[j].length()==0) continue;
                d+="/"+temp[j];
                if(set.contains(d)){
                    break;
                }
            }
            // System.out.println();
            if(temp.length==1) d=curr;
            //System.out.println(curr+" "+d);
            if(!set.contains(d)){
                set.add(curr);
                ans.add(curr);
            }
            
        }
        return ans;
    }
}