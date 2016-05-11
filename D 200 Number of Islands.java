//https://leetcode.com/problems/number-of-islands/
//计算岛的个数
//移除的方法 未用到并查集、BFS、DFS
//一个新颖的用法：https://leetcode.com/discuss/41509/7-lines-python-14-lines-java
public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        int count = 0;
        int m = grid.length, n = grid[0].length;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] != '0') {
                    count++;
                    removeIsland(grid, m, n, i, j);
                }
            }
        }
        return count;
    }
    
    public void removeIsland(char[][] grid, int m, int n, int i, int j) {
        if(i<0 || j<0 || i==m || j==n || grid[i][j]=='0')
            return;
        grid[i][j] = '0';
        removeIsland(grid, m, n, i+1, j);
        removeIsland(grid, m, n, i, j+1);
        removeIsland(grid, m, n, i-1, j);
        removeIsland(grid, m, n, i, j-1);
        
    }
