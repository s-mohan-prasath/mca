package backtracking;

import java.util.*;

class Sudoku {
    char[][] globalBoard;
    public static void main(String[] args){
        char[][] sudokuGrid = {
                {'5', '3', '.', '6', '7', '8', '9', '.', '2'},
                {'6', '7', '2', '1', '9', '5', '3', '4', '8'},
                {'.', '9', '8', '3', '4', '2', '5', '6', '7'},
                {'8', '5', '9', '7', '6', '1', '4', '2', '3'},
                {'4', '2', '6', '8', '5', '3', '7', '9', '1'},
                {'7', '1', '3', '9', '.', '4', '8', '5', '6'},
                {'9', '6', '.', '5', '3', '7', '2', '8', '4'},
                {'2', '8', '7', '4', '1', '9', '6', '3', '5'},
                {'3', '4', '5', '2', '8', '6', '1', '7', '9'}
        };
        new Sudoku(sudokuGrid);
    }
    public Sudoku(char[][] board) {
        sudoku(board, 0, 0);
        for (char[] b : globalBoard) {
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
        char[][] clonedBoard = clone(board);
        int row=i,col=j;
        boolean anyoneFound = false;
        for(;row<9;row++){
            for(;col<9;col++){
                if(board[row][col]=='.'){
                    for(char c='1';c<='9';c++){
                        if(isValid(board,row,col,c)){
                            clonedBoard[row][col] = c;
                            if(sudoku(clonedBoard,row,col))return true;
                        }
                    }
                    if(anyoneFound==false)return false;
                }
            }
            col = 0;
        }
        if(row==9 && col==9){
            globalBoard = clonedBoard;
            return true;
        }
        return false;
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

