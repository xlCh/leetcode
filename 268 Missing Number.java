//nums为0~n数组（缺少一个元素），找出这个元素
//位操作方法：result = nums.length 然后result ^= i, result ^= nums[i]

public int missingNumber(int[] nums) {
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
        }
        return nums.length*(nums.length+1)/2-sum;
    }
