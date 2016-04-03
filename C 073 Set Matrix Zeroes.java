//https://leetcode.com/problems/set-matrix-zeroes/
//将矩阵中所有为0的横竖都设为0
//巧妙解法，把第1行第1列标注为0，要注意！！

public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean horizontalFirst = false, verticalFirst = false;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j] == 0) {
                    if(i == 0)
                        horizontalFirst = true;
                    if(j == 0)
                        verticalFirst = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        

        //可拆为两个for，也可以把这几个for合起来
        for(int i=1; i<m; i++) {//要从1开始 从0开始就错了
            for(int j=1; j<n; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(horizontalFirst) {
            for(int j=0; j<n; j++)
                matrix[0][j] = 0;
        }
        if(verticalFirst) {
            for(int i=0; i<m; i++)
                matrix[i][0] = 0;
        }
    }
