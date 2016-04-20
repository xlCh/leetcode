//https://leetcode.com/problems/coin-change/
//指定面额硬币凑钱
//另一种减的方法：https://leetcode.com/discuss/85610/9-lines-concise-and-easy-understand-c-solution-dp
public int coinChange(int[] coins, int amount) {
        int[] nums = new int[amount+1];
        nums[0] = 0;
        for(int i=1; i<=amount; i++) {
            nums[i] = Integer.MAX_VALUE;
        }
        for(int i=0; i<amount; i++) {
            for(int coin : coins) {
                if(i+coin <= amount && nums[i] != Integer.MAX_VALUE) {
                    nums[i+coin] = Math.min(nums[i+coin], nums[i] + 1);
                }
            }
        }
        return nums[amount] == Integer.MAX_VALUE ? -1 : nums[amount];
    }
