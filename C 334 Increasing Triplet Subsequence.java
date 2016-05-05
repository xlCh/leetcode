//https://leetcode.com/problems/increasing-triplet-subsequence/
//是否有三个递增的数字 类似300题
//O(n)解法：https://leetcode.com/discuss/86593/clean-and-short-with-comments-c
public boolean increasingTriplet(int[] nums) {
        int len = 0;
		int[] dp = new int[nums.length];
		for(int num : nums) {
			int i = Arrays.binarySearch(dp, 0, len, num);
			if(i < 0)
				i = -(i+1);
			dp[i] = num;
			if(i == len)
				if(++len == 3)
					return true;
		}
		return false;
    }
