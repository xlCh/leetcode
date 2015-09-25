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
