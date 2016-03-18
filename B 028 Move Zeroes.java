//https://leetcode.com/problems/move-zeroes/
//将0移到数组尾部
//另一种只循环一次的方法：循环过程中边统计0的个数 边交换0和非0元素的位置（下标由0的个数决定）

public void moveZeroes(int[] nums) {
        int addNum = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != 0)
                nums[i-addNum] = nums[i];
            else
                addNum++;
        }
        for(int i=nums.length-addNum; i<nums.length; i++)
            nums[i] = 0;
    }
