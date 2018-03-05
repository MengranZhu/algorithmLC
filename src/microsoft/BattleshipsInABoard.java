package src.microsoft;

/*
* leetcode: 419 Battleships in a Board
solution: iterate each element and find if it is a battleship
if it is check it previous horizon and vertical to check if it is the same one
* */
public class BattleshipsInABoard {
    public int countBattleships(char[][] board) {
        int res = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') continue;
                if (i > 0 && board[i - 1][j] == 'X') continue;
                if (j > 0 && board[i][j - 1] == 'x') continue;
                res++;
            }
        }
        return res;
    }
}
