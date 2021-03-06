//https://leetcode.com/problems/rotate-array/
//int数组整个右移k位
//还有空间复杂度为O(1)的解法 一种是进行三次数组reverse（左、右、加起来），一种是逐步替换（需要考虑k和nums.length最大公约数不为1的情况）

public void rotate(int[] nums, int k) {
        k = k % nums.length;
		int n = nums.length - k;
		int[] temp = new int[n];
		for(int i=0; i<nums.length; i++) {
			if(i < n) {
				temp[i] = nums[i];
			}
			else {
				nums[i-n] = nums[i];
			}
		}
		for(int i=0; i<n; i++) {
			nums[k+i] = temp[i];
		}
    }

//空间复杂度O(1):
public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }
    
    public void reverse(int[] nums, int start, int end) {
		while(start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}
