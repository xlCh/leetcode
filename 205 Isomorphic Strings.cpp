//判断一个单词是否能通过字符替换的方式用另一个代替
//一开始采用map，但发现执行时间过长
bool isIsomorphic(string s, string t) {
        if(s.length() == 0)
            return true;
        char charmap1[255] = {0};
        char charmap2[255] = {0};
        for(int i=0; i<s.length(); i++) {
            if(charmap1[s.at(i)] == 0) {
                charmap1[s.at(i)] = t.at(i);
            }
            else if(charmap1[s.at(i)] != t.at(i))
                return false;
            if(charmap2[t.at(i)] == 0) {
                charmap2[t.at(i)] = s.at(i);
            }
            else if(charmap2[t.at(i)] != s.at(i))
                return false;
        }
        return true;
    }
