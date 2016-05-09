//https://leetcode.com/problems/divide-two-integers/
//做除法 但不能用* / %
//递归解法：https://leetcode.com/discuss/57346/clean-java-solution-with-some-comment
//使用long的做法 参考https://leetcode.com/discuss/38997/detailed-explained-8ms-c-solution
public int divide(int dividend, int divisor) {
        if(divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1))
            return Integer.MAX_VALUE;
        boolean isPositive = false;
        if((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0))
            isPositive = true;
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        if(ldividend < ldivisor)
            return 0;
        long result = 0;
        while(ldividend >= ldivisor) {
            long temp = ldivisor, multi = 1;
            while((ldividend >> 1) >= temp) {
                temp <<= 1;
                multi <<= 1;
            }
            ldividend -= temp;
            result += multi;
        }
        return (int)(isPositive ? result : -result);
    }
