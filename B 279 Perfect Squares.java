//https://leetcode.com/problems/perfect-squares/
//平方和 最小数字
//dp解法
//four-square理论：https://leetcode.com/discuss/87524/java-use-lagranges-four-square-theorem
//https://leetcode.com/discuss/87524/java-use-lagranges-four-square-theorem
public int numSquares(int n) {
        int[] minNums = new int[n+1];
        for(int i=1; i<=n; i++) {
            int sqrt = (int)Math.sqrt(i);
            int min = minNums[i-1];
            for(int j=1; j<=sqrt; j++) {
                if(minNums[i-j*j] < min)
                    min = minNums[i-j*j];
            }
            minNums[i] = min + 1;
        }
        return minNums[n];
    }
