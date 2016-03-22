//https://leetcode.com/problems/longest-common-prefix/
//返回最长的相同前缀
//另一种思路，直接比较整个前缀 https://leetcode.com/discuss/92804/1ms-easy-to-understand-java-solution
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

//简化了一些 java
public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        int length = Integer.MAX_VALUE;
        for(int i=0; i<strs.length; i++) {
            length = Math.min(length, strs[i].length());
        }
        for(int i=0; i<length; i++) {
            int ch = strs[0].charAt(i);
            for(int j=1; j<strs.length; j++) {
                if(strs[j].charAt(i) != ch)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0].substring(0, length);
    }
