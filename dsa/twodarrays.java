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
}