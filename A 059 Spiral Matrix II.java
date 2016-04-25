//https://leetcode.com/problems/spiral-matrix-ii/
//生成n×n矩阵（转圈）

public int[][] generateMatrix(int n) {
        int num = 1;
        int[][] result = new int[n][n];
        int start = 0, end = n-1;
        while(start < end) {
            int i;
            for(i=start; i<end; i++) {
                result[start][i] = num++;
            }
            for(i=start; i<end; i++) {
                result[i][end] = num++;
            }
            for(i=end; i>start; i--) {
                result[end][i] = num++;
            }
            for(i=end; i>start; i--) {
                result[i][start] = num++;
            }
            start++;
            end--;
        }
        if(start == end)
            result[start][start] = num;
        return result;
    }

//不需要这么多for的做法
public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int num = 1;
        int start = 0, end = n-1;
        while(start < end) {
            int temp = num;
            for(int i=start, j=end; i<end && j>start; i++, j--) {
                result[start][i] = temp;
                result[i][end] = temp + (end - start);
                result[end][j] = temp + 2 * (end - start);
                result[j][start] = temp + 3 * (end - start);
                temp++;
            }
            num += 4 * (end - start);
            start++;
            end--;
        }
        if(start == end)
            result[start][start] = num;
        return result;
    }
