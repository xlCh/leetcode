//https://leetcode.com/problems/longest-increasing-subsequence/
//寻找串中最长的子字符串
//O(nlogn)解法：https://leetcode.com/discuss/67609/short-java-solution-using-dp-o-n-log-n
//以下是O(n2)解法
public int lengthOfLIS(int[] nums) {
        int len = nums.length;
		if(len <= 1)
			return len;
		int[] results = new int[len];
		for(int i=0; i<len; i++) {
			results[i] = 1;
		}
		int result = 1;
		for(int i=0; i<len; i++) {
			for(int j=0; j<i; j++) {
				if(nums[j] < nums[i] && results[j]+1 > results[i]) {
					results[i] = results[j] + 1;
					if(results[i] > result)
						result = results[i];
				}
			}
		}
		return result;
    }
