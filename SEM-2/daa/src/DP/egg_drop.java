package DP;

import java.util.Arrays;
import java.util.Scanner;

public class egg_drop {
    static int[][] dp;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.printf("Enter number of floors : ");
        int n = scan.nextInt();
        System.out.printf("Enter number of eggs : ");
        int e = scan.nextInt();
        dp = new int[n+1][e+1];
        for(int i = 0;i<n+1;i++){
            dp[i][0] = 0;
            dp[i][1] = i;
        }
        for(int i = 0;i<e+1;i++){
            dp[1][i] = 1;
            dp[0][i] = 0;
        }
        for(int i = 2;i<=n;i++){
            for(int j = 2;j<=e;j++){
                egg_drop(i,j);
            }
        }
        for(int[] arr:dp){
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void egg_drop(int n,int e){
        dp[n][e] = Integer.MAX_VALUE;
        for(int x = 1;x<n;x++){
            dp[n][e] = MIN(dp[n][e],MAX(dp[n-x][e],dp[x-1][e-1])+1);
        }
    }
    public static int MIN(int a, int b){
        return (a>b) ? b : a;
    }
    public static int MAX(int a, int b){
        return (a>b) ? a : b;
    }
}
