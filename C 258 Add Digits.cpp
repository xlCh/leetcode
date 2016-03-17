//https://leetcode.com/problems/add-digits/
//数字各位相加直到小于10
//有些慢，有更快的方法
/*
公式介绍：https://en.wikipedia.org/wiki/Digital_root
答案简化版，也可应用于负数：(num - 1) % 9 + 1
证明：
假设对于三位数abc=100*a+10*b+c--减去9的倍数-->a+b+c
a+b+c mod 9 即为abc mod 9，只需要计算原数字除以9所得的余数（还有特殊情况 9和0）
return num%9!=0?num%9:(num==0?0:9); //可简化
*/
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
