//寻找最大子串

public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int maxSum = sum;
        for(int i=1; i<nums.length; i++) {
            sum = sum + nums[i] > nums[i]?sum + nums[i]:nums[i]; //精简的一句 不用考虑大于或小于0的问题
            if(sum > maxSum)
                maxSum = sum;
        }
        return maxSum;
    }
