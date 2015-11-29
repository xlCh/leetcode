//从小到大排列数组元素的序列 下一个

public class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        for(i = nums.length - 2; i>=0; i--) {
            if(nums[i] < nums[i+1])
                break;
        }
        if(i != -1) {
            int j = nums.length - 1;
            while(j > i && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i+1, nums.length-1);
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void reverse(int[] nums, int i, int j) {
        while(i < j) {
            swap(nums, i++, j--);
        }
    }
}
