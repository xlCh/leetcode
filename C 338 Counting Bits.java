//https://leetcode.com/problems/counting-bits/
//计算0~n一串数中2的位数
//动态规划 位操作方法：https://leetcode.com/discuss/92609/three-line-java-solution
//位操作方法2：https://leetcode.com/discuss/92796/four-lines-c-time-o-n-space-o-n

public int[] countBits(int num) {
        int[] result = new int[num+1];
        int base = 1;
        int t = 0;
        for(int i=1; i<=num; i++) {
            if(i == base) {
                base <<= 1;
                t = 0;
            }
            result[i] = result[t++] + 1;
        }
        return result;
    }
