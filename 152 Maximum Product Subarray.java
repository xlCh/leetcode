//数组中元素的最大乘积

public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], result = nums[0];
        for(int i=1; i<nums.length; i++) {
            if(nums[i] > 0) {
                max = Math.max(max * nums[i], nums[i]);
                min = Math.min(min * nums[i], nums[i]);
            }
            else {
                int tempMax = max;
                max = Math.max(min * nums[i], nums[i]);
                min = Math.min(tempMax * nums[i], nums[i]);
            }
            result = Math.max(result, max);
        }
        return result;
    }
