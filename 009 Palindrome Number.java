//判断数字是否为回文

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
            int divide = (int)Math.pow(10, i);
            if(x % 10 != x/divide)
                return false;
            x %= divide;
            x /= 10;
        }
        return true;
    }
