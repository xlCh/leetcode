//m到n的所有数按位与
//位运算 注意规律

    public int rangeBitwiseAnd(int m, int n) {
        int i = 0;
        while(m != n) {
            m >>= 1;
            n >>= 1;
            i++;
        }
        return n << i;
    }
