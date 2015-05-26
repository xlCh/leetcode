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
