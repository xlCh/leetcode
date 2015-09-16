//序列1, 11, 21, 1211 ... 
//求序列第n个的值

string countAndSay(int n) {
        string temp = "1";
        for(int i=1; i<n; i++) {
            temp = sayNum(temp);
        }
        return temp;
    }
    
    string sayNum(string n) {
        string str = "";
        for(int i=0; i<n.length(); i++) {
            char temp = n.at(i++);
            int count = 1;
            while(i<n.length() && n.at(i) == temp) {
                count++;
                i++;
            }
            i--;
            str += char(count+48);
            str += temp;
        }
        return str;
    }
