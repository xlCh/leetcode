//https://leetcode.com/problems/unique-binary-search-trees/
//可生成二叉搜索树的个数，即卡特兰数
//其实属于dp解法，详解见https://leetcode.com/discuss/86650/fantastic-clean-java-dp-solution-with-detail-explaination
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
