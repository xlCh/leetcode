//https://leetcode.com/problems/maximal-square/
//只有0和1的矩阵 求最大的方块
//最简练的代码：https://leetcode.com/discuss/50506/extremely-simple-java-solution

    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int max = 0;
        int[][] maxSquare = new int[matrix.length][matrix[0].length];
        for(int i=0; i<matrix.length; i++) {
            maxSquare[i][0] = matrix[i][0] - '0';
            if(maxSquare[i][0] == 1)
                max = 1;
        }
        for(int i=0; i<matrix[0].length; i++) {
            maxSquare[0][i] = matrix[0][i] - '0';
            if(maxSquare[0][i] == 1)
                max = 1;
        }
        for(int i=1; i<matrix.length; i++) {
            for(int j=1; j<matrix[0].length; j++) {
                if(matrix[i][j] == '1') {
                    maxSquare[i][j] = Math.min(Math.min(maxSquare[i][j-1] , maxSquare[i-1][j-1]), maxSquare[i-1][j]) + 1;
                    if(maxSquare[i][j] > max)
                        max = maxSquare[i][j];
                }
            }
        }
        return max * max;
    }
