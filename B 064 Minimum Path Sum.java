//https://leetcode.com/problems/minimum-path-sum/
//m×n方格 左上到右下最短路径 动态规划
//更短的时间：不需要这么多的循环和条件判断 https://leetcode.com/discuss/91302/c-solution-beat-98-59%25
public int minPathSum(int[][] grid) {
        int length = grid.length;
        int width = grid[0].length;
        if(length == 0 || width == 0)
            return 0;
        for(int i=1; i<length; i++) {
            grid[i][0] = grid[i-1][0] + grid[i][0];
        }
        for(int j=1; j<width; j++) {
            grid[0][j] = grid[0][j-1] + grid[0][j];
        }
        for(int i=1; i<length; i++) {
            for(int j=1; j<width; j++) {
                grid[i][j] = (grid[i-1][j] < grid[i][j-1] ? grid[i-1][j] : grid[i][j-1]) + grid[i][j];
            }
        }
        return grid[length-1][width-1];
    }
