//https://leetcode.com/problems/rotate-image/
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

//另一种做法
public void rotate(int[][] matrix) {
        int n = matrix.length;
        int start = 0, end = n-1;
        while(start < end) {
            for(int i=start, j=end; i<end && j>start; i++, j--) {
            	int temp = matrix[start][i];
            	matrix[start][i] = matrix[j][start];
            	matrix[j][start] = matrix[end][j];
            	matrix[end][j] = matrix[i][end];
            	matrix[i][end] = temp;
            }
            start++;
            end--;
        }
    }
