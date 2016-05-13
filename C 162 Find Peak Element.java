//https://leetcode.com/problems/find-peak-element/
//查找peak number 二分查找
//三种方法：https://leetcode.com/discuss/17793/find-the-maximum-by-binary-search-recursion-and-iteration
public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length-1, medium = (low+high) / 2;
        while(low < high) {
            if(nums[medium] < nums[medium+1])
                low = medium + 1;
            else
                high = medium;
            medium = (low + high) / 2;
        }
        return low;
    }
