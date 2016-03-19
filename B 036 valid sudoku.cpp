//https://leetcode.com/problems/valid-sudoku
//判断数独是否符合规则（横、竖、九宫格）
bool isValidSudoku(vector<vector<char>>& board) {
        int num3[9][9] = {0,0,0,0,0,0,0,0,0};
        for(int i = 0; i<9; i++) {
            int num1[9] = {0,0,0,0,0,0,0,0,0};
            int num2[9] = {0,0,0,0,0,0,0,0,0};
            for(int j=0; j<9; j++) {
                if(board.at(i).at(j) != '.') {
                    if(++num1[board.at(i).at(j)-49] == 2)
                        return false;
                    if(++num3[3*(j/3)+i/3][board.at(i).at(j)-49] == 2)
                        return false;
                }
                if(board.at(j).at(i) != '.') {
                    if(++num2[board.at(j).at(i)-49] == 2)
                        return false;
                }
            }
        }
        return true;
    }
