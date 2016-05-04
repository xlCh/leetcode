//https://leetcode.com/problems/powx-n/
//计算x的n次幂
//注意从n开始除 如果从1开始乘 数大会溢出
//位操作解法：https://leetcode.com/discuss/12004/my-answer-using-bit-operation-c-implementation
//递归解法：https://leetcode.com/discuss/73885/exponentiation-by-squaring-java-1ms-ac
//不需要转换long，直接考虑负数（下面的评论） https://leetcode.com/discuss/85636/similar-idea-with-binary

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

//注意MIN_VALUE
public double myPow(double x, int n) {
        if(n == 0 || x == 1)
			return 1;
		double result = 1;
		long m = n;
		if(m < 0) {
		    x = 1 / x;
		    m = -m;
		}
		while(m >= 1) {
		    if(m % 2 == 1)
		        result *= x;
		    m >>= 1;
		    x *= x;
		}
		return result;
    }
