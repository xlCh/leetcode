//https://leetcode.com/problems/3sum-closest/
//数组中三个数相加 返回最接近target的值
//类似3Sum
//稍微简练一些：https://leetcode.com/discuss/16335/java-solution-with-o-n2-for-reference
 public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for(int i=0; i<nums.length;) {
            int start = i+1, end = nums.length-1, temp = nums[i];
            while(start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                int temp1 = nums[start], temp2 = nums[end];
                if(sum < target) {
                	if(target - sum < Math.abs(target - result)) {
                		result = sum;
                	}
                	while(start < end && nums[start] == temp1) start++;
                }
                else if(sum == target)
                	return sum;
                else {
                	if(sum - target < Math.abs(target - result)) {
                		result = sum;
                	}
                	while(start < end && nums[end] == temp2) end--;
                }
            }
            while(i<nums.length && nums[i] == temp) i++;
        }
        return result;
    }
