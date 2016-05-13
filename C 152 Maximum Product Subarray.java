//https://leetcode.com/problems/maximum-product-subarray/
//数组中元素的最大乘积
//大同小异的方法 https://leetcode.com/discuss/14235/possibly-simplest-solution-with-o-n-time-complexity
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

//更直观一些
public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], result = nums[0];
		for(int i=1; i<nums.length; i++) {
			int tempMax = max * nums[i], tempMin = min * nums[i];
			max = Math.max(Math.max(tempMax, tempMin), nums[i]);
			min = Math.min(Math.min(tempMax, tempMin), nums[i]);
			if(result < max)
				result = max;
		}
		return result;
    }
