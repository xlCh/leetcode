//求整数按二进制翻转后的数
//例如43261596(00000010100101000001111010011100) -> 964176192(00111001011110000010100101000000)
//速度更快的方法：位操作
uint32_t reverseBits(uint32_t n) {
        if(n == 0)
            return 0;
        uint32_t result = 0;
        int i = 0;
        while(n != 1) {
            result += (n % 2) * pow(2, 31-(i++));
            n = n/2;
        }
        result += pow(2, 31-i);
        return result;
    }
