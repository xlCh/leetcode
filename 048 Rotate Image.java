//将n*n数组顺时针旋转90度 不消耗额外空间

public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i=0; 2*i<n; i++) {
            for(int j=i; j<n-i-1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = temp;
            }
        }
    }
