//计算小于n的非负整数中质数的个数

public int countPrimes(int n) {
        if(n < 2)
        	return 0;
        int primeNum = 0;
        boolean[] isPrime = new boolean[n+1];
        for(int k=0; k<n+1; k++) {
        	isPrime[k] = true;
        }
        int i=2;
        while(i < n) {
        	if(isPrime[i] == true) {
        	    primeNum++;
        		for(int j=0; j<=n/i; j++) {
        			isPrime[j*i] = false;
        		}
        	}
        	i++;
        }
        
        return primeNum;
    }
}
