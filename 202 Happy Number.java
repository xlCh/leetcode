//happy number
//每位上的平方 最终和为1，即为happy number

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
