import java.util.*;

class Sudoku {
    char[][] output;

    public Sudoku(char[][] board) {
        sudoku(board, 0, 0);
        for (char[] b : output) {
            System.out.println(Arrays.toString(b));
        }
    }

    private char[][] clone(char[][] board) {
        char[][] newBoard = new char[9][9];
        for (int i = 0; i < 9; i++) {
            newBoard[i] = board[i].clone();
        }
        return newBoard;
    }

    private boolean sudoku(char[][] board, int i, int j) {
        for (int row = i; row < 9; row++) {
            for (int col = j; col < 9; col++) {
                if (board[row][col] == '.') {
                    boolean allPossibleValues = false;
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, row, col, c)) {
                            char[][] newB = clone(board);
                            newB[row][col] = c;
                            allPossibleValues = true;
                            if (sudoku(newB, row, col))
                                return true;
                        }
                    }
                    if (allPossibleValues == false)
                        return false;
                }
                if (i == 8 && j == 8) {
                    output = board;
                    return true;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c)
                return false;
            if (board[i][col] == c)
                return false;
            if (board[3 * (row / 3) + (i / 3)][3 * (col / 3) + (i % 3)] == c)
                return false;
        }
        return true;
    }

}
