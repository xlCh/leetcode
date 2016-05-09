//https://leetcode.com/problems/permutation-sequence/
//第k个序列
//https://leetcode.com/discuss/19357/efficient-solution-without-previous-calculation-factorial
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

//大同小异
public String getPermutation(int n, int k) {
        int total = 1;
        List<Integer> elements = new LinkedList<Integer>();
        StringBuilder result = new StringBuilder();
        for(int i=1; i<=n; i++) {
            total *= i;
            elements.add(i);
        }
        k--;
        for(int i=1; i<=n; i++) {
            int size = elements.size();
            int index = k * size / total;
            result.append(elements.remove(index));
            total /= size;
            k %= total;
        }
        return result.toString();
    }
