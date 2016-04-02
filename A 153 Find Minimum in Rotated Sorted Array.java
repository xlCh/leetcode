//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
//寻找有序数组rotate以后的最小值

public int findMin(int[] nums) {
        int low = 0, high = nums.length-1;
        int middle = (low+high) / 2;
        while(low < high) {
        //可优化 if (nums[left] < nums[right]) return nums[left];
        //对应下面的代码也可以精简
            if(nums[middle] > nums[low] && nums[low] > nums[high])
                low = middle + 1;
            else if((nums[middle] > nums[low] && nums[low] < nums[high]) || nums[middle] < nums[low])
                high = middle;
            else
                return nums[low]>nums[high]?nums[high]:nums[low];
            middle = (low+high) / 2;
        }
        return nums[low];
    }

public int findMin(int[] nums) {
        if(nums.length == 0)
            return 0;
        int low = 0, high = nums.length - 1;
        int medium = low + (high - low) / 2;
        while(low < high - 1) {
            if(nums[medium] < nums[high]) {
                high = medium;
            else if(nums[medium] > nums[low]) 
                low = medium + 1;
            medium = low + (high - low) / 2;
        }
        return (low+1<nums.length && nums[low+1]<nums[low]) ? nums[low+1] : nums[low];
    }
}
