class Solution {
public:
    string destCity(vector<vector<string>>& paths) {
        set<string> set;
        int i,j,m=paths.size();
        for(i=0;i<m;i++)
        {
            string a=paths[i][0];
            string b=paths[i][1];
            set.insert(a);
        }
        for(i=0;i<m;i++)
        {
            string a=paths[i][0];
            string b=paths[i][1];
            if(set.find(b)==set.end())
            return b;  
        }
        return "";
    }
};