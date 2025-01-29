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

    public boolean prob4(int[][] arr, int ele) {
        int i, j, m, n, mid1 = 0, mid2, kstart, kend;
        m = arr[0].length;
        n = arr.length;

        if (n == 0 || m == 0)
            return false;
        i = 0;
        j = m - 1;
        kstart = 0;
        kend = n - 1;

        mid1 = (kstart + kend) / 2;
        // BINARY SEARCH TO SEARCH A APPROPRIATE ROW
        while (kstart != kend) {
            if (arr[mid1][0] == ele || arr[mid1][m - 1] == ele)
                return true;
            else if (arr[mid1][0] < ele && arr[mid1][m - 1] > ele)
                break;
            else if (arr[mid1][0] < ele)
                kstart = mid1 + 1;
            else if (arr[mid1][0] > ele)
                kend = mid1 - 1;
            mid1 = (kstart + kend) / 2;

        }
        if (arr[mid1][0] == ele)
            return true;

        mid2 = (i + j) / 2;

        // BINARY SEARCH TO SEARCH A APPROPRIATE COLUMN IN A ROW
        while (i != j) {
            if (arr[mid1][mid2] == ele)
                return true;
            else if (arr[mid1][mid2] > ele)
                j = mid2 - 1;
            else
                i = mid2 + 1;
            mid2 = (i + j) / 2;
        }
        if (arr[mid1][mid2] == ele)
            return true;
        return false;
    }

    public void prob5(int[][] arr) {
        int len, sr, er, sc, ec, i, j, k, stage, mid;
        len = arr.length;
        mid = len / 2;
        sr = 0;
        er = len - 1;
        sc = 0;
        ec = len - 1;

        k = 0;
        stage = 1;
        while (k < mid) {
            i = sr;
            j = sc;
            while (true) {
                System.out.println(arr[i][j]);
                if (stage == 1) {
                    if (j == ec) {
                        stage = 2;
                        i++;
                    } else {
                        j++;
                    }
                } else if (stage == 2) {
                    if (i == er) {
                        stage = 3;
                        j--;
                    } else {
                        i++;
                    }
                } else if (stage == 3) {
                    if (j == sr) {
                        if (len % 2 == 0 && i == mid)
                            break;
                        stage = 4;
                        i--;
                    } else {
                        j--;
                    }
                } else if (stage == 4) {
                    if (i == sr + 1)
                        break;
                    i--;
                }
            }
            k++;
            sr++;
            er--;
            sc++;
            ec--;
            stage = 1;
        }
        if (len % 2 == 0)
            return;
        System.out.println(arr[mid][mid]);
    }
}