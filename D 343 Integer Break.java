//https://leetcode.com/problems/integer-break/
//将num拆为几个数令它们乘积最大
//普通dp解法
//dp 递归：https://leetcode.com/discuss/98249/easy-to-understand-c-with-explanation
//dp 非递归（评论中优化了一些）：https://leetcode.com/discuss/98143/java-dp-solution
//数字3的证明： https://leetcode.com/discuss/98377/share-some-thought-process-about-this-problem
//              https://leetcode.com/discuss/98276/why-factor-2-or-3-the-math-behind-this-problem
//找规律，参考https://leetcode.com/discuss/98173/o-log-n-time-solution-with-explanation
    public int integerBreak(int n) {
        if(n == 2)
            return 1;
        else if(n == 3)
            return 2;
        else if(n % 3 == 0)
            return (int)Math.pow(3, n/3);
        else if(n % 3 == 1)
            return 4 * (int)Math.pow(3, (n-4)/3);
        else
            return 2 * (int)Math.pow(3, n/3);
    }
