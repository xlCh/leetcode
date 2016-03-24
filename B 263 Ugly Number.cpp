//https://leetcode.com/problems/ugly-number/
//判断ugly number(只被2、3、5整除，1也算是ugly number)
//有耗时更短方法 3个while  return num==1
bool isUgly(int num) {
        if(num == 0)
            return false;
        while(true) {
            if(num == 1)
                return true;
            if(num % 2 == 0) {
                num /= 2;
                continue;
            }
            if(num % 3 == 0) {
                num /= 3;
                continue;
            }
            if(num % 5 == 0) {
                num /= 5;
                continue;
            }
            return false;
        }
        return true;
    }
