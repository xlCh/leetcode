//计算下标i到j的数字和

public class NumArray {
    
    int[] sums;

    public NumArray(int[] nums) {
        int sum = 0;
        sums = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            sums[i] = sum + nums[i];
            sum = sums[i];
        }
    }

    public int sumRange(int i, int j) {
        return i==0?sums[j]:sums[j]-sums[i-1];
    }
}
