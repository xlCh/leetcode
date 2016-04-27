//https://leetcode.com/problems/single-number-ii/
//其他数字均出现3次 找出仅出现一次的数字
//更简便但不易懂 https://leetcode.com/discuss/44345/java-bit-manipulation-solution
public int singleNumber(int[] nums) {
        int[] bits = new int[32];
        for(int i=0; i<32; i++) {
            for(int j=0; j<nums.length; j++) {
                bits[i] += (nums[j] & (1 << i)) >> i;
            }
            bits[i] %= 3;
        }
        int result = 0;
        for(int i=0; i<32; i++)
            result |= bits[i] << i;
        return result;
    }

//更易懂
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i=0; i<32; i++) {
            int mask = 1 << i, count = 0;
            for(int num : nums) {
                count += (num & mask);
            }
            if(count % 3 != 0) {
                result |= mask;
            }
        }
        return result;
    }
