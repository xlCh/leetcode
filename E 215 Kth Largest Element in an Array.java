//https://leetcode.com/problems/kth-largest-element-in-an-array/
//找出数组中第k大的数
//略去先排序再找和PriorityQueue的方法
//快的 https://leetcode.com/discuss/88064/97%25-2ms-java-quick-select-solution
//参考，但太慢 https://leetcode.com/discuss/45627/ac-clean-quickselect-java-solution-avg-o-n-time
public int findKthLargest(int[] nums, int k) {
        int index = find(nums, 0, nums.length-1, nums.length-k+1);
        return nums[index];
    }
	
	public int find(int[] nums, int start, int end, int k) {
		int i = start, j = end, pivot = nums[end];
		while(i < j) { //while里面的内容可以写成一句：if (a[i++] > pivot) swap(a, --i, --j);
			if(nums[i] <= pivot) {
				i++;
				continue;
			}
			swap(nums, i, --j);
		}
		swap(nums, i, end);
		int less = i - start + 1;
		if(less == k)
			return i;
		else if(less > k)
			return find(nums, start, i-1, k);
		else
			return find(nums, i+1, end, k-less);
	}
	
	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
