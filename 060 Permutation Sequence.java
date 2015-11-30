//第k个序列
//根据规律计算

public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<Integer>();
        int[] factorials = new int[n+1];
        factorials[0] = 1;
        String result = "";
        for(int i=1; i<=n; i++) {
            nums.add(i);
            factorials[i] = factorials[i-1] * i;
        }
        for(int i=n; i>0; i--) {
            int temp = (k-1) / factorials[i-1];
            result += nums.remove(temp);
            k = (k-1) % factorials[i-1] + 1;
        }
        return result;
    }
