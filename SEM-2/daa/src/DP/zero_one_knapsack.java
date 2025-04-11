package DP;

import java.lang.reflect.Array;
import java.util.Arrays;

public class zero_one_knapsack {
    int[] W, P;
    int[][] V;
    public zero_one_knapsack(int n,int m,int[] W,int[] P){
        this.W = W;
        this.P = P;
        this.V = new int[n+1][m+1];
        for(int i = 1;i<=n;i++){
            for(int w=1;w<=m;w++){
                fun(i,w);
            }
        }
        for (int[] arr : V){
            System.out.println(Arrays.toString(arr));
        }
    }
    public void fun(int i,int w){
        this.V[i][w] = Math.max(V[i-1][w],this.P[i-1]+((w-this.W[i-1]<0)?Integer.MIN_VALUE :V[i-1][w-this.W[i-1]]));
    }
}
