//https://leetcode.com/problems/search-insert-position
//寻找一个数在数组中的插入位置，如果存在则直接返回下标
//更精简的代码 把start初始值设置为-1 https://leetcode.com/discuss/88085/standard-binary-search-template-maybe-better-than-other-posts
public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        if(target < nums[low])
            return 0;
        if(target > nums[high])
            return nums.length;
        int middle = (low + high) / 2;
        while(low < high - 1) {
            if(target > nums[middle])
                low = middle;
            else if(target < nums[middle])
                high = middle;
            else
                return middle;
            middle = (low + high) / 2;
        }
        if(nums[low] == target)
            return low;
        return high;
    }
