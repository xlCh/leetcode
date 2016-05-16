//https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
//在旋转后的有序数组中查找元素，允许元素重复
//先排除首尾相等的情况 https://leetcode.com/discuss/30308/java-solution-with-comments
//参考（注意边界条件） https://leetcode.com/discuss/60618/neat-java-solution-using-binary-search
public boolean search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int medium;
        while(low <= high) {
            medium = (low + high) >>> 1;
            if(nums[medium] == target)
                return true;
            if(nums[medium] < nums[high] || nums[low] > nums[medium]) {
                if(target > nums[medium] && target <= nums[high])
                    low = medium + 1;
                else
                    high = medium - 1;
            }
            else if(nums[low] < nums[medium] || nums[medium] > nums[high]) {
                if(target >= nums[low] && target < nums[medium])
                    high = medium - 1;
                else
                    low = medium + 1;
            }
            else
                high--;
        }
        return false;
    }
