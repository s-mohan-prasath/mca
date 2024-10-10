import java.util.*;

public class twodarrays_strings_2 {
    public twodarrays_strings_2() {
    }

    public void printArrayList(ArrayList<ArrayList<Integer>> arr) {
        for (ArrayList<Integer> x : arr) {
            System.out.println(x.toString());
        }
    }

    public int prob1(int[][] arr) {
        /*
         * Given an m x n matrix, return true if the matrix is Toeplitz. Otherwise,
         * return false.
         * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the
         * same elements.
         */
        int i, j, k, mid, iter, startI, startJ, x, mid2, row, col, prev;
        row = arr.length;
        col = arr[0].length;
        x = Math.abs(row - col);
        iter = row + col + x - 3;
        mid = row - 1;
        mid2 = mid + x;
        startI = row - 2;
        startJ = 0;
        k = 0;
        while (k < iter - x) {
            i = startI;
            j = startJ;
            prev = arr[i][j];
            while (i < row) {
                if (prev != arr[i][j]) {
                    System.out.println("Given Matrix is not Toeptliz Matrix");
                    return 0;
                }
                System.out.printf("i = %d, j = %d, val = %d\n", i, j, arr[i][j]);
                i++;
                j++;
            }
            if (k >= mid2 - 1) {
                row--;
            }
            if (k < mid - 1) {
                startI--;
            } else {
                startJ++;
            }
            System.out.printf("\n");
            k++;
        }
        System.out.println("Given Matrix is a Toeplitz Matrix");
        return 1;
    }
    public void prob4(){
        
    }
}