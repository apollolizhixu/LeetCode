public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return true;
        }
        boolean[] check = new boolean[9];
        
        for (int i = 0; i < 9; i++) {
            Arrays.fill(check, false);
            for (int j = 0; j < 9; j++) {
                if (Character.isDigit(board[i][j])) {
                    if (check[(int)(board[i][j] - '1')]) {
                        return false;
                    }
                    check[(int)(board[i][j] - '1')] = true;
                }
            }
        }
        for (int j = 0; j < 9; j++) {
            Arrays.fill(check, false);
            for (int i = 0; i < 9; i++) {
                if (Character.isDigit(board[i][j])) {
                    if (check[(int)(board[i][j] - '1')]) {
                        return false;
                    }
                    check[(int)(board[i][j] - '1')] = true;
                }
            }
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                Arrays.fill(check, false);
                for (int k = 0; k < 9; k++) {
                    if (Character.isDigit(board[i + k / 3][j + k % 3])) {
                        if (check[(int)(board[i + k / 3][j + k % 3] - '1')]) {
                            return false;
                        }
                        check[(int)(board[i + k / 3][j + k % 3] - '1')] = true;
                    }
                }
            }
        }
        return true;
    }
}