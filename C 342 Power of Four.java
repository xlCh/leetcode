//https://leetcode.com/problems/power-of-four/
//判断是否是4的幂
//不用循环和递归的写法：https://leetcode.com/discuss/98484/share-my-c-solution-with-explanation-easy-to-understand

    public boolean isPowerOfFour(int num) {
        int powerOfFour = 1;
        while(powerOfFour <= num && powerOfFour > 0) {
	        if(num == powerOfFour)
		        return true;
	        powerOfFour <<= 2;
        }
        return false;
    }
