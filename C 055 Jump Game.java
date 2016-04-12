//https://leetcode.com/problems/jump-game/
//Jump game 是否能跳到最后一个元素
//还有一种方法是倒着遍历

public boolean canJump(int[] nums) {
        int maxJump = nums[0];
        for(int i=0; i<=maxJump; i++) {
            maxJump = Math.max(maxJump, i+nums[i]);
            if(maxJump >= nums.length-1)
                return true;
        }
        return false;
    }
