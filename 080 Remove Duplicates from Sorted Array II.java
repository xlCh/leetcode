//从有序数组中移除重复元素（重复次数>2），返回数组长度

public int removeDuplicates(int[] nums) {
        int low = 0;
        for(int high=0; high<nums.length; ) {
            nums[low++] = nums[high];
            int temp = nums[high++];
            if(high<nums.length && nums[high] == nums[high-1]) {
                nums[low++] = nums[high++];
                while(high < nums.length && nums[high] == temp) {
                    high++;
                }
            }
        }
        return low;
    }
