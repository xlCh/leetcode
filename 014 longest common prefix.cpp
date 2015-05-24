//返回最长的相同前缀
string longestCommonPrefix(vector<string>& strs) {
        if (strs.size() == 0)
            return "";
        vector<string>::iterator iter;
        int minLength = strs[0].length();
        for ( iter = strs.begin() ; iter != strs.end() ; iter++ )
        {
            if((*iter).length() < minLength) {
                minLength = (*iter).length();
            }
        }
        if(minLength == 0)
            return "";
        string reStr = "";
        for(int i=0; i<minLength; i++) {
            char character = strs[0].at(i);
            for(int j=0; j<strs.size(); j++) {
                if (strs[j].at(i) != character)
                    return reStr;
            }
            reStr.append(1, character);
        }
        return reStr;
    }
