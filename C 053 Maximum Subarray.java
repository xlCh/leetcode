//https://leetcode.com/problems/maximum-subarray/
//寻找最大子串
//另一种类似buy and sell stock的解法：https://leetcode.com/discuss/83182/another-o-n-solution
//分治解法：https://leetcode.com/discuss/13569/share-my-solutions-both-greedy-and-divide-and-conquer
//https://leetcode.com/discuss/694/how-solve-maximum-subarray-using-divide-and-conquer-approach
public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int maxSum = sum;
        for(int i=1; i<nums.length; i++) {
            sum = sum + nums[i] > nums[i]?sum + nums[i]:nums[i]; //精简的一句 不用考虑大于或小于0的问题
            if(sum > maxSum)
                maxSum = sum;
        }
        return maxSum;
    }
