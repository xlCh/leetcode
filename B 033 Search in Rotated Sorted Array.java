//https://leetcode.com/problems/search-in-rotated-sorted-array/
//在移位后的数组中进行搜索（例如[4,5,6,7,1,2,3]）
//可使用递归 https://leetcode.com/discuss/86567/java-binary-search-with-recursion
//主要是注意仔细分析各种情况
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int medium = low + (high - low) / 2;
        if(target > nums[high] && target < nums[low])
            return -1;
        while(low < high - 1) {
            if(nums[medium] == target)
                return medium;
            if(nums[medium] < target) {
                if(nums[low] > nums[high] && nums[medium] < nums[high] && nums[low] <= target)
                    high = medium;
                else
                    low = medium;
            }
            else if(nums[medium] > target) {
                if(nums[low] > nums[high] && nums[medium] > nums[low] && nums[high] >= target)
                    low = medium;
                else
                    high = medium;
            }
            medium = low + (high - low) / 2;
        }
        if(nums[low] == target)
            return low;
        if(nums[high] == target)
            return high;
        return -1;
    }
