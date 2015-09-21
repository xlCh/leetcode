//n!里0的个数
int trailingZeroes(int n) {
        if(n < 5)
            return 0;
        int res = 0;
        while(n > 0)
        {
            int tmp = n / 5;
            res += tmp;
            n /= 5;
        }
        return res;
    }
