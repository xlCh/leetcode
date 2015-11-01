//盗窃，所有房子形成一个环

public int rob(int[] nums) {
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return nums[0]>nums[1]?nums[0]:nums[1];
        int[] value = new int[nums.length-1];
        value[0] = nums[0];
        value[1] = nums[0] > nums[1]?nums[0]:nums[1];
        int[] value2 = new int[nums.length-1];
        value2[0] = nums[1];
        value2[1] = nums[1] > nums[2]?nums[1]:nums[2];
        for(int i=2; i<nums.length-1; i++) {
            value[i] = value[i-2]+nums[i] > value[i-1] ? value[i-2]+nums[i] : value[i-1];
            value2[i] = value2[i-2]+nums[i+1] > value2[i-1] ? value2[i-2]+nums[i+1] : value2[i-1];
        }
        int max1 = value[nums.length-2];
        int max2 = value2[nums.length-2];
        return max1>max2?max1:max2;
    }
