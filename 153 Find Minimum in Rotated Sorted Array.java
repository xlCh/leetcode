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
