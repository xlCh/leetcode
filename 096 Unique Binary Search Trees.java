//可生成二叉搜索树的个数
//即卡特兰数

public int numTrees(int n) {
        int[] c = new int[n+1];
        c[0] = 1;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=i; j++) {
                c[i] += c[j-1] * c[i-j];
            }
        }
        return c[n];
    }
