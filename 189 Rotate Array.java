//int数组整个右移k位
//还有空间复杂度为O(1)的解法 待考虑

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
