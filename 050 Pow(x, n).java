//计算x的n次幂
//注意从n开始除 如果从1开始乘 数大会溢出
//位操作解法：https://leetcode.com/discuss/12004/my-answer-using-bit-operation-c-implementation

public double myPow(double x, int n) {
        if(x == 0)
            return 0;
        if(n == 0)
            return 1;
        if(n < 0) {
            n = -n;
            x = 1/x;
        }
        double result = 1;
        while(n>0){
            if(n % 2 == 1) 
                result *= x;
            x *= x;
            n /= 2;
        }
        return result;
    }
