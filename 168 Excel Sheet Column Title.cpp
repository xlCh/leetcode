//将数字转换为excel标题（1->A, 26->Z, 27->AA等）
string convertToTitle(int n) {
        string str = "";
        while(n != 0) {
            str = (char)((n-1) % 26 + 65) + str;
            n = (n-1) / 26;
        }
        return str;
    }
