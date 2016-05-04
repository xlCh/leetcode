//https://leetcode.com/problems/bitwise-and-of-numbers-range/
//m到n的所有数按位与
//位运算 注意规律
//递归解法 https://leetcode.com/discuss/34918/one-line-c-solution
    public int rangeBitwiseAnd(int m, int n) {
        int i = 0;
        while(m != n) {
            m >>= 1;
            n >>= 1;
            i++;
        }
        return n << i;
    }

//大同小异
public int rangeBitwiseAnd(int m, int n) {
        int base = 1;
        while(m != n) {
            m >>= 1;
            n >>= 1;
            base <<= 1;
        }
        return m * base;
    }
