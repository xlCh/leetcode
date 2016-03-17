//https://leetcode.com/problems/excel-sheet-column-number/
//输出excel中列代表的数字（例如A=1,AA=27...）

int titleToNumber(string s) {
        int sum = 0;
        for(int i=s.length()-1; i>=0; i--) {
            sum = sum + ((s.at(i)-64) * pow(26,(s.length()-i-1)));
        }
        return sum;
    }
