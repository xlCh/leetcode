//https://leetcode.com/problems/number-of-1-bits/
//判断二进制1的个数
//大杀器：__builtin_popcount函数。。。
int hammingWeight(uint32_t n) {
        if(n == 0)
            return 0;
        int totalOne = 0;
        while(n != 1)  {
            totalOne += n % 2;
            n /= 2;
        }
        if(n == 1) {
            totalOne++;
        }
        return totalOne;
    }

//Java
//第1种 需要转int为long
public int hammingWeight(int n) {
        long n1 = (long)n;
        if(n < 0)
            n1 = (long)Integer.MAX_VALUE + ((long)Integer.MAX_VALUE+2+n);
        int result = 0;
        while(n1 > 0) {
            result += (n1 % 2);
            n1 /= 2;
        }
        return result;
}

//一些位操作的方法
//使用n&(n-1)消掉最低位的1
for (;n!=0;n = n & (n-1))
        count++;
//有疑问 关于i的左移
for(int i = 0; i < 32; i++) {
        if(((1 << i) & n) != 0) {
            count++;
        }
    }
//没有第一种位操作简洁
while (n != 0) {
        count++;
        n ^= n & ~(n - 1);
        }
