//https://leetcode.com/problems/single-number/
//数组中只有一个数是单独出现的，其他都是成对出现，求这个数
//利用0^N=N, N^N=0

public int singleNumber(int[] nums) {
        int single = 0;
        for(int num : nums) {
            single ^= num;
        }
        return single;
    }
