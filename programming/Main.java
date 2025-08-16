
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // kmp("a", "aaaaabaaa");
        System.out.println(matrixMultiplication(new int[] { 2, 1, 3, 4 }));
    }

    private static void kmp(String pat, String s) {
        int patLen, sLen, point;
        patLen = pat.length();
        sLen = s.length();
        int[] lps = new int[patLen];
        // updating elements in lps
        point = 0;
        for (int i = 1; i < patLen; i++) {
            if (pat.charAt(i) == pat.charAt(point)) {
                lps[i] = (++point);
            } else {
                point = 0;
            }
        }
        System.out.print(Arrays.toString(lps));
        point = 0;
        for (int i = 0; i < sLen; i++) {
            if (s.charAt(i) == pat.charAt(point)) {
                if (point == patLen - 1) {
                    System.out.println("i=" + (i - point) + "\n");
                    point = 0;
                } else {
                    point++;
                }
            } else {
                point = point != 0 ? lps[point - 1] : 0;
                if (pat.charAt(point) == s.charAt(i)) {
                    point++;
                } else {
                    point = 0;
                }
            }
        }
    }

    private static int min(int a, int b) {
        return (a < b) ? a : b;
    }

    private static int matrixMultiplication(int[] arr) {
        //flipkart, microsoft and FactSet
        int n = arr.length;
        int[][] dp = new int[n][n];

        int start = 1;
        int k = 1, i, j;
        while (k < n) {
            i = start;
            j = i + k;
            while (i < n && j < n) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int l = i; l < j; l++) {
                    dp[i][j] = min(dp[i][j], dp[i][l] + dp[l + 1][j] + arr[i - 1] * arr[l] * arr[j]);
                }
                i++;
                j++;
            }
            k++;
        }
        return dp[1][n - 1];
    }
}