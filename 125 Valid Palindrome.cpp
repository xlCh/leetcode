//判断是否为回文，不考虑标点符号（但考虑数字）
bool isPalindrome(string s) {
    if (s == "") {
        return true;
    }
    int i=0, j=s.length()-1;
    while(i < j) {
        if(s.at(i) < 48 || (s.at(i) > 57 && s.at(i) < 65) || (s.at(i) > 90 && s.at(i) < 97) || s.at(i) > 122) {
            i++;
            continue;
        }
        if(s.at(j) < 48 || (s.at(j) > 57 && s.at(j) < 65) || (s.at(j) > 90 && s.at(j) < 97) || s.at(j) > 122) {
            j--;
            continue;
        }
        if(tolower(s.at(i)) != tolower(s.at(j))) {
            return false;
        }
        i++;
        j--;
    }
    return true;
}
