//和为s的最短子串长度

public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0)
            return 0;
        int slow = 0, fast = 0;
        int minLen = Integer.MAX_VALUE;
        int currentSum = 0;
        while(fast < nums.length) {
            while(currentSum < s && fast < nums.length) {
                currentSum += nums[fast++];
            }
            while(currentSum-nums[slow] >= s) {//可精简掉此循环
                currentSum -= nums[slow++];
            }
            if(fast == nums.length && slow == 0 && currentSum < s) //可精简至结尾判断minLen是否为Integer.MAX_VALUE
                return 0;
            minLen = Math.min(minLen, fast-slow);
            currentSum -= nums[slow++];
        }
        return minLen;
    }
