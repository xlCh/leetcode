//https://leetcode.com/problems/search-for-a-range/
//搜索target所在范围，返回start和end的上下标
//两遍扫描 但runtime 0ms
public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = searchLeft(nums, target);
        result[1] = searchRight(nums, target);
        return result;
    }
	
	public int searchLeft(int[] nums, int target) {
		int low = 0, high = nums.length - 1;
		int medium = low + (high - low) / 2;
		while(low < high - 1) {
			if(nums[medium] < target)
				low = medium + 1;
			else if(nums[medium] > target)
				high = medium - 1;
			else
				high = medium;
			medium = low + (high - low) / 2;
		}
		return nums[low] == target ? low : (nums[high] == target ? high : -1);
	}
	
	public int searchRight(int[] nums, int target) {
		int low = 0, high = nums.length - 1;
		int medium = low + (high - low) / 2;
		while(low < high - 1) {
			if(nums[medium] < target)
				low = medium + 1;
			else if(nums[medium] > target)
				high = medium - 1;
			else
				low = medium;
			medium = low + (high - low) / 2;
		}
		return nums[high] == target ? high : (nums[low] == target ? low : -1);
	}
