//https://leetcode.com/problems/power-of-two/
//判断整数是否为2的n次幂
bool isPowerOfTwo(int n) {
        if(n <= 0)
            return false;
        while(n > 0 && n != 1) {
            if(n % 2 != 0)
                return false;
            n = n/2;
        }
        return true;
    }

//位操作
//return (n > 0) && ((n&(n-1)) == 0);  利用其特性
//return n>0&&1073741824%n==0; 
