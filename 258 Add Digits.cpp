//数字各位相加直到小于10
//有些慢，有更快的方法
//(num - 1) % 9 + 1

int addDigits(int num) {
        while(num > 9) {
            int temp = num;
            int sum = 0;
            while(temp / 10 != 0) {
                sum += temp % 10;
                temp /= 10;
            }
            sum += temp;
            num = sum;
        }
        return num;
    }
