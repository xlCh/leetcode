//https://leetcode.com/problems/plus-one/
//+1操作
vector<int> plusOne(vector<int>& digits) {
        if (digits.size() == 0) {
            return digits;
        }
        int i = digits.size() - 1;
        if(digits[i] != 9) {
            digits[i] += 1;
            return digits;
        }
        while(digits[i] == 9 && i != 0) {
            digits[i--] = 0;
        }
        if(i != 0) {
            digits[i] += 1;
            return digits;
        }
        else if(i == 0 && digits[i] == 9) {
            digits[i] = 0;
            digits.insert(digits.begin(), 1);
            return digits;
        }
        else {
            digits[i] += 1;
            return digits;
        }
    }
