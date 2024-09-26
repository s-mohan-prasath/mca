import java.util.*;

public class twodarrays {
    public twodarrays() {

    }

    public void prob1(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;

        int val = Math.round(((float) row * col) / 2);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] == 0) {
                    val--;
                }
            }
        }
        if (val == 0) {
            System.out.println("The given matrix is Sparse matrix");
        } else {
            System.out.println("The given matrix is not Sparse matrix");
        }

    }

    public void prob2(int[][] arr) {
        int row, col, sum, lt, rt, lb, rb;
        row = arr.length;
        col = arr[0].length;

        lt = arr[0][0];
        rt = arr[0][col - 1];
        lb = arr[row - 1][0];
        rb = arr[row - 1][col - 1];

        sum = lt + rt + lb + rb;
        System.out.printf("%d %d %d %d\n", lt, lb, rt, rb);
        System.out.println("Corner Sum is " + sum);

    }

    public void prob3(int[][] arr) {
        /**
         * startRow - start index row of the square matrix
         * endRow - end index row of square matrix
         * startCol - start index column of square matrix
         * endCol - end index column of square matrix
         * 
         * tlCol - top left element index of square matrix (column value changes in
         * every iteration)
         * trRow - top right element index of square matrix (row value changes in every
         * iteration)
         * blRow - bottom left element index of square matrix (row value changes in
         * every iteration)
         * brCol - bottom right element index of square matrix (column value changes in
         * every iteration)
         */
        int len, mid, i, temp, startRow, endRow, startCol, endCol, tlCol, trRow, blRow, brCol;
        len = arr.length;
        mid = len / 2;

        if (len == 1) {
            System.out.println(Arrays.deepToString(arr));
            return;
        }

        startRow = 0;
        endRow = len - 1;
        startCol = 0;
        endCol = len - 1;

        i = 0;
        while (i < mid) {
            int j = startCol;

            tlCol = startCol;
            trRow = startRow;
            blRow = endRow;
            brCol = endCol;

            while (j < endCol) {
                temp = arr[startRow][tlCol];
                arr[startRow][tlCol] = arr[blRow][startCol];
                arr[blRow][startCol] = arr[endRow][brCol];
                arr[endRow][brCol] = arr[trRow][endCol];
                arr[trRow][endCol] = temp;

                j++;
                tlCol++;
                trRow++;
                blRow--;
                brCol--;
            }
            startRow++;
            endRow--;
            startCol++;
            endCol--;
            i++;
        }
        System.out.println(Arrays.deepToString(arr));
    }
}