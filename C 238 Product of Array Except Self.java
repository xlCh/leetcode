//https://leetcode.com/problems/product-of-array-except-self/
//数组中除自己之外其他元素的乘积 不能用除法
//分别从左边和右边开始乘
//可以在一个循环中搞定 https://leetcode.com/discuss/87865/how-from-o-n-to-o-1
public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        for(int i=1; i<nums.length; i++) {
            result[i] = result[i-1] * nums[i-1];
        }
        int temp = 1;
        for(int i=nums.length-1; i>=0; i--) {
            result[i] *= temp;
            temp *= nums[i];
        }
        return result;
    }
