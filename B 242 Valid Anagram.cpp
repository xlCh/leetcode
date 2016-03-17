//https://leetcode.com/problems/valid-anagram/
//检查两个单词是否为颠倒字母顺序的（anagram）
//可以更优化 可以在第一个for循环中s++第二个for循环中t-- 遇到<=0的情况直接return false
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
