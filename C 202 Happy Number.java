//https://leetcode.com/problems/happy-number
//happy number
//每位上的平方 最终和为1，即为happy number
//注意，退出条件：n < 10 && n != 1，这样不用额外借助数据结构 https://leetcode.com/discuss/87470/3-ms-java-solution-in-o-1-space
public boolean isHappy(int n) {
        List<Integer> already = new ArrayList<Integer>();
        while(!already.contains(n)) {
            already.add(n);
            int sum = 0;
            while(n != 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            if(sum == 1)
                return true;
            n = sum;
        }
        return false;
    }
