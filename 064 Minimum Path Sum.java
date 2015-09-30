//m×n方格 左上到右下最短路径 动态规划

public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] paths = new int[m][n];
        int count = 0;
        for(int i=0; i<m; i++) {
            count += grid[i][0];
            paths[i][0] = count;
        }
        count = 0;
        for(int i=0; i<n; i++) {
            count += grid[0][i];
            paths[0][i] = count;
        }
        if(m <= 1 || n <= 1)
            return paths[m-1][n-1];
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                paths[i][j] = (paths[i-1][j]>paths[i][j-1]?paths[i][j-1]:paths[i-1][j]) + grid[i][j];
            }
        }
        return paths[m-1][n-1];
    }
