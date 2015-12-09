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
