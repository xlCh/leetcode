//其他数字均出现3次 找出仅出现一次的数字

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
