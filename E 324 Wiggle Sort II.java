//https://leetcode.com/problems/wiggle-sort-ii/
//排序，令nums[0] < nums[1] > nums[2] < nums[3]...
//利用额外空间的 https://leetcode.com/discuss/76965/3-lines-python-with-explanation-proof
//利用index mapping：https://leetcode.com/discuss/77115/o-n-time-o-1-space-solution-with-detail-explanations
//（上一行链接方法的详细解释）参考https://leetcode.com/discuss/95156/step-by-step-explanation-of-index-mapping-in-java
public void wiggleSort(int[] nums) {
        int median = findKthLargest(nums, (nums.length+1)/2);
        int n = nums.length;
        int left = 0, i = 0, right = n-1;
        while(i <= right) {
            if(nums[newIndex(i, n)] > median) {
                swap(nums, newIndex(left++, n), newIndex(i++, n));
            }
            else if(nums[newIndex(i, n)] < median) {
                swap(nums, newIndex(right--, n), newIndex(i, n));
            }
            else
                i++;
        }
    }
    
    public int newIndex(int index, int n) {
        return (1 + 2*index) % (n|1);//n|1为不小于n的第一个奇数
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public int findKthLargest(int[] nums, int k) {
        final int N = nums.length;
        Arrays.sort(nums);
        return nums[N - k];
  }
