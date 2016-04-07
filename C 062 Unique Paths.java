//https://leetcode.com/problems/unique-paths/
//m×n方格 路径条数 动态规划
//可降维：https://leetcode.com/discuss/94614/sharing-my-0ms-java-solution-with-detailed-exploration
//可使用数学中的组合：https://leetcode.com/discuss/90663/two-simpe-java-solutions-using-dp-and-combination
//Suppose for a 3x4 matrix, the total steps you need to take is 3+4-2 = 5, 
//so the question turns out to be: in these 5 steps, 2 are towards right and 3 steps are towards down. 
//Thus it is a combination question: which 2 steps are to the right and which 3 steps are going down? 
//So C52 = 5! / (2! x 3 !) = (5x4)/(2x1) = 10
public int uniquePaths(int m, int n) {
        if(m <= 1 || n <= 1)
            return 1;
        int[][] paths = new int[m][n];
        for(int i=0; i<m; i++) {
            paths[i][0] = 1;
        }
        for(int i=0; i<n; i++) {
            paths[0][i] = 1;
        }
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                paths[i][j] = paths[i-1][j] + paths[i][j-1];
            }
        }
        return paths[m-1][n-1];
    }
