//https://leetcode.com/problems/surrounded-regions/
//并查集 https://leetcode.com/discuss/6285/solve-it-using-union-find
public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0)
            return;
        int m = board.length, n = board[0].length;
        if(m == 1 || n == 1)
            return;
        for(int i=0; i<m; i++) {
            if(board[i][0] == 'O')
                bfs(board, m, n, i, 0);
            if(board[i][n-1] == 'O')
                bfs(board, m, n, i, n-1);
        }
        for(int j=0; j<n; j++) {
            if(board[0][j] == 'O')
                bfs(board, m, n, 0, j);
            if(board[m-1][j] == 'O')
                bfs(board, m, n, m-1, j);
        }
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == '*')
                    board[i][j] = 'O';
                else if(board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }
    
    public void bfs(char[][] board, int m, int n, int i, int j) {
        board[i][j] = '*';
        if(i > 1 && board[i-1][j] == 'O')
            bfs(board, m, n, i-1, j);
        if(i < m-2 && board[i+1][j] == 'O')
            bfs(board, m, n, i+1, j);
        if(j > 1 && board[i][j-1] == 'O')
            bfs(board, m, n, i, j-1);
        if(j < n-2 && board[i][j+1] == 'O')
            bfs(board, m, n, i, j+1);
    }
