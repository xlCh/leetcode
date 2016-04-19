//https://leetcode.com/problems/word-search/
//在二维字符数组中搜索指定词

public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(exist(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean exist(char[][] board, int i, int j, String word, int start) {
        if(start == word.length())
            return true;
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(start))
            return false;
        char temp = board[i][j];
        board[i][j] = ' ';
        boolean result = exist(board, i-1, j, word, start+1) || exist(board, i+1, j, word, start+1)
                        || exist(board, i, j-1, word, start+1) || exist(board, i, j+1, word, start+1);
        board[i][j] = temp;
        return result;
    }
