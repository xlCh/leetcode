//返回数组中两个只出现一次的数（其余均出现两次）

public int[] singleNumber(int[] nums) {
        int xXORy = 0;
        for(int num : nums) {
            xXORy ^= num;
        }
        //得到x和y最小的不同位
        int diff = xXORy & (~(xXORy-1));
        int x = 0;
        for(int num : nums) {
            //注意位运算优先级
            if((num & diff) != 0)
                x ^= num;
        }
        int[] result = new int[2];
        result[0] = x;
        result[1] = x ^ xXORy;
        return result;
    }
