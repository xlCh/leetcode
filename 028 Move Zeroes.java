//将0移到数组尾部

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