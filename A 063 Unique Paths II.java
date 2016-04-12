//https://leetcode.com/problems/unique-paths-ii/
//判断m×n矩阵中左上角到右下角可能的走法个数（含障碍）

public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] paths = new int[m][n];
        paths[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for(int i=1; i<m; i++) {
        	if(obstacleGrid[i][0] == 1)
        	    paths[i][0] = 0;
        	else
        	    paths[i][0] = paths[i-1][0];
        }
        for(int i=1; i<n; i++) {
            if(obstacleGrid[0][i] == 1)
        	    paths[0][i] = 0;
        	else
        	    paths[0][i] = paths[0][i-1];
        }
        for(int i=1; i<m; i++) {
        	for(int j=1; j<n; j++) {
        	    if(obstacleGrid[i][j] == 1)
        	        paths[i][j] = 0;
        	    else
        		    paths[i][j] = paths[i-1][j] + paths[i][j-1];
        	}
        }
        return paths[m-1][n-1];
    }
