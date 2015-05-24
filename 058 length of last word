//判断最后一个词的长度
//代码太不精练了
int lengthOfLastWord(string s) {
        string s2 = deleteSpace(s);
        if(s2 == "")
            return 0;
        else {
            int pos = s2.rfind(' ');
            if(pos == string::npos) {
                return s2.length();
            }
            else {
                return s2.length() - pos - 1;
            }
        }
        
    }
    
    string deleteSpace(string s) {
        int pos = -1;
        int first = 0;
        while(pos != s.length()-1) {
            if(s.find(' ', pos) != string::npos) {
                first = s.find(' ', pos);
                pos = first;
                while(s.find(' ', pos) == pos && pos != s.length()-1) {
                    pos++;
                }
                if(first == 0 && pos == s.length()-1) {
                    if (s.at(pos) == ' ')
                        return "";
                    else
                        s.assign(1, s.at(pos));
                        return s;
                }
                if(first == 0) {
                    s.replace(first, pos-first, "");
                    pos -= pos-first+1;
                }

                else if(pos == s.length()-1) {
                        cout << "Aaa";
                    s.replace(first, pos-first+1, "");
                    cout << first << "     " << pos-first+1 << endl;
                    return s;
                }
                else {
                    s.replace(first, pos-first, " ");
                    pos -= pos-first;
                }

            }
            else if(s == " ") {
                return "";
            }
            pos++;
        }
        return s;
    }
