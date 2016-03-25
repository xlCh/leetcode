//https://leetcode.com/problems/string-to-integer-atoi/
//字符串转int的实现
//情况较多，代码冗余较严重，待改进。。
//java最快的方法 https://leetcode.com/discuss/86651/my-nice-java-code-3ms
int myAtoi(string str) {
        int startIndex;
        bool hasNum = false;
        bool hasMinus = false;
        for(startIndex=0; startIndex<str.length(); startIndex++) {
            if(str.at(startIndex) == 32)
                continue;
            if(str.at(startIndex) == 43) {
                if((startIndex-1>=0 && str.at(startIndex-1) == 45) || startIndex+1>=str.length() || str.at(startIndex+1) < 48 || str.at(startIndex+1) > 57)
                    break;
                continue;
            }
            if(str.at(startIndex) == 45) {
                if((startIndex-1>=0 && str.at(startIndex-1) == 43) || startIndex+1>=str.length() || str.at(startIndex+1) < 48 || str.at(startIndex+1) > 57)
                    break;
                hasMinus = true;
                continue;
            }
            if(str.at(startIndex) >= 48 && str.at(startIndex) <= 57) {
                hasNum = true;
            }
            break;
        }
        if(!hasNum)
            return 0;
        int endIndex = startIndex;
        while(endIndex < str.length() && str.at(endIndex) >= 48 && str.at(endIndex) <= 57)
            endIndex++;
        int total = 0;
        int times = 1;
        for(int i=endIndex-1; i>=startIndex; i--) {
            //int temp = (str.at(i)-48) * times;
            //cout << temp << "  " << str.at(i)-48 << "  " << times << endl;
            //if(temp / times != str.at(i)-48)
            //    return hasMinus?-2147483648:2147483647;
            total += (str.at(i)-48) * times;
            if(times * 10 / 10 == times)
                times *= 10;
            else if(i==startIndex && total > 0)
                break;
            else
                return hasMinus?-2147483648:2147483647;
        }
        if(-total > total)
            return -2147483648;
        return hasMinus?(-total):total;
    }
