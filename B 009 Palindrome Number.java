//https://leetcode.com/problems/palindrome-number/
//判断数字是否为回文
//另一种方法 反向 https://leetcode.com/discuss/91814/simple-java-o-1-space-solution
public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        int digitCount = 0;
        int temp = x;
        while(temp / 10 != 0) {
            digitCount++;
            temp /= 10;
        }
        for(int i=digitCount; i>=0; i=i-2) {
            int divide = (int)Math.pow(10, i); //放在最外层 快一点
            if(x % 10 != x/divide)
                return false;
            x %= divide;
            x /= 10;
        }
        return true;
    }
