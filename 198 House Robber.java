//盗窃问题 动态规划，不能盗窃相邻的房间，求最大价值

public int rob(int[] nums) {
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        int[] value = new int[nums.length];
        value[0] = nums[0];
        value[1] = nums[0] > nums[1]?nums[0]:nums[1];
        for(int i=2; i<nums.length; i++) {
            value[i] = value[i-2]+nums[i] > value[i-1] ? value[i-2]+nums[i] : value[i-1];
        }
        return value[nums.length-1];
    }
