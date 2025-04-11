package DP;

import java.lang.reflect.Array;
import java.util.Arrays;

public class longest_common_subsequence {
    String A,B;
    int n,m;
    int[][] dp;
    public longest_common_subsequence(String A,String B){
        this.n = A.length();
        this.m = B.length();
        this.A = A;
        this.B = B;

        this.dp = new int[n+1][m+1];

        for(int i = 1;i<=n;i++){
            for(int j=1;j<=m;j++){
                fun(i,j);
            }
        }
        for (int[] arr : dp){
            System.out.println(Arrays.toString(arr));
        }
    }
    public void fun(int i,int j){
        if(A.charAt(i-1)==B.charAt(j-1)){
            dp[i][j] = 1+dp[i-1][j-1];
        }else{
            dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
        }
    }
}
