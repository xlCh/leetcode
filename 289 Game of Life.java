//康威生存游戏

//代码过长，有短一点的解法：
//https://leetcode.com/discuss/62864/java-bit-manipulation-solution
//https://leetcode.com/discuss/62173/clear-java-solution

//空间无限的解法
//https://leetcode.com/discuss/62185/infinite-board-solution

public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int liveNum = getLiveNum(board, i, j);
                if(board[i][j] == 1 && (liveNum == 2 || liveNum == 3))
                    continue;
                else if(board[i][j] == 1)
                    board[i][j] = -1;
                else if(liveNum == 3)
                    board[i][j] = 2;
            }
        }
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == 2)
                    board[i][j] = 1;
                else if(board[i][j] == -1)
                    board[i][j] = 0;
            }
        }
    }
    
    public int getLiveNum(int[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        int liveNum = 0;
        if(i-1 >= 0) {
            if(j-1 >= 0)
                if(board[i-1][j-1] == 1 || board[i-1][j-1] == -1) liveNum++;
            if(j+1 < n)
                if(board[i-1][j+1] == 1 || board[i-1][j+1] == -1) liveNum++;
            if(board[i-1][j] == 1 || board[i-1][j] == -1) liveNum++;
        }
        if(j-1 >= 0)
            if(board[i][j-1] == 1 || board[i][j-1] == -1) liveNum++;
        if(j+1 < n)
            if(board[i][j+1] == 1 || board[i][j+1] == -1) liveNum++;
        if(i+1 < m) {
            if(j-1 >= 0)
                if(board[i+1][j-1] == 1 || board[i+1][j-1] == -1) liveNum++;
            if(j+1 < n)
                if(board[i+1][j+1] == 1 || board[i+1][j+1] == -1) liveNum++;
            if(board[i+1][j] == 1 || board[i+1][j] == -1) liveNum++;
        }
        return liveNum;
    }
