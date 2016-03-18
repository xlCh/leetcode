//https://leetcode.com/problems/nim-game/
//取石头游戏 是否能赢 一次可以取走1~3个
//只要取走石头后剩下4的倍数 就能保证赢（对方取1~3，自己取4-x）

public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
