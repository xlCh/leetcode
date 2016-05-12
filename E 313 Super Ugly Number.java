//https://leetcode.com/problems/super-ugly-number/
//给定几个ugly number，求由这几个数字组成的从小到大序列的第k个数
//heap解法 https://leetcode.com/discuss/81411/java-three-methods-23ms-58ms-with-heap-performance-explained
//参考，注意ugly numberII的解法 https://leetcode.com/discuss/72835/108ms-easy-to-understand-java-solution
public int nthSuperUglyNumber(int n, int[] primes) {
        int[] index = new int[primes.length];
        int[] result = new int[n];
        result[0] = 1;
        for(int i=1; i<n; i++) {
            result[i] = Integer.MAX_VALUE;
            for(int j=0; j<primes.length; j++) {
                result[i] = Math.min(result[index[j]] * primes[j], result[i]);
            }
            for(int j=0; j<primes.length; j++) {
                if(result[i] % primes[j] == 0) {
                    index[j]++;
                    //break;
                }
            }
        }
        return result[n-1];
    }
