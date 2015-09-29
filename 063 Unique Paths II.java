//判断m×n矩阵中左上角到右下角可能的走法个数（含障碍）

public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(m <= 1 && n <= 1)
            return 1-obstacleGrid[0][0];
        int[][] paths = new int[m][n];
        boolean hasObstacle = false;
        for(int i=0; i<m; i++) {
            if(obstacleGrid[i][0] == 1)
                hasObstacle = true;
            if(!hasObstacle)
                paths[i][0] = 1;
            else
                paths[i][0] = 0;
        }
        hasObstacle = false;
        for(int i=0; i<n; i++) {
            if(obstacleGrid[0][i] == 1)
                hasObstacle = true;
            if(!hasObstacle)
                paths[0][i] = 1;
            else
                paths[0][i] = 0;
        }
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                if(obstacleGrid[i][j] != 1)
                    paths[i][j] = paths[i-1][j] + paths[i][j-1];
                else
                    paths[i][j] = 0;
            }
        }
        return paths[m-1][n-1];
    }
