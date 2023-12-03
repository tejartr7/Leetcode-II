class Solution {
public:
    vector<vector<int>>vec;
    int func(int x,int k,string s)// Standard sliding window approach counting substrings with length x*k with each character occuring exactly k times 
	{  
        int ans=0;
        for(auto &it:vec){
            int i=it[0],j=it[0],e=it[1];
            int cntk=0;
            unordered_map<char,int>mp;
            for(j=it[0];j<=e;j++)
			{
                mp[s[j]]++;
                if(mp[s[j]]==k) cntk++;
                if(j-i+1>(x*k)){
                    mp[s[i]]--;
                    if(mp[s[i]]==(k-1)) cntk--;
                    if(mp[s[i]]==0) mp.erase(s[i]);
                    i++;
                }
                if(mp.size()==x && cntk==mp.size()) ans++;
            }
		}
        return ans;
    }
    int countCompleteSubstrings(string word, int k) {
        vector<int>v;
        string s=word;
        for(int i=1;i<s.size();i++){
            if(i<s.size() && abs(s[i]-s[i-1])>2) v.push_back(i);
        }
        
        
        
        int st=0,e=s.size()-1;
        for(auto &it:v){
            if(st<=it-1)
            vec.push_back({st,it-1});
            st=it;
        }
       if(st<=e)
       vec.push_back({st,e}); // vec will store ranges in which substring can be formed
        
       int ans=0;
       for(int i=1;i<=26 && i*k<=s.size();i++){
           ans+=func(i,k,word); // func will return number of substrings with i different characters each occuring exactly k times
       }
       return ans;
    }
};