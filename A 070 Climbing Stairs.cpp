//https://leetcode.com/problems/climbing-stairs/
//爬楼梯，一次爬1或2节，求总共可能的数量
//可简化为O(1) space 无需数组
int climbStairs(int n) {
        vector<int> dp(n, 0);
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 2; i < n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n - 1];
    }
