//检查两个单词是否为颠倒字母顺序的（anagram）
//未知runtime分布情况
bool isAnagram(string s, string t) {
        if(s.length() != t.length())
            return false;
        int sChars[26] = {0};
        int tChars[26] = {0};
        for(int i=0; i<s.length(); i++) {
            sChars[s.at(i)-97]++;
            tChars[t.at(i)-97]++;
        }
        for(int i=0; i<26; i++) {
            if(sChars[i] != tChars[i])
                return false;
        }
        return true;
    }
