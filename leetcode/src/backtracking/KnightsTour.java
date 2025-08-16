package backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class KnightsTour {
    static int cells = 0;
    static int newI,newJ;
    static int[][] a = {{+1,+2},{-1,+2},{+2,+1},{+2,-1},{+1,-2},{-1,-2},{-2,+1},{-2,-1}};
    static int[][] gdp;
    static int n;
    public static void main(String args[]){
        n = 10;
        cells = n*n;
        int[][] arr = new int[n][n];
        for(int i = 0;i<n;i++){
            Arrays.fill(arr[i],-1);
        }
//        int[][] matrix = {{0,5,14,9,20},{13,8,19,4,15},{18,1,6,21,10},{7,12,-1,16,3},{-1,17,2,11,22}};
        tour(0,0,0,arr);
        print();
    }
    public static boolean tour(int c,int i,int j,int[][] dp){
        int[][] cloned = clone(dp);
        cloned[i][j] = c++;
        if(cells == c){
            gdp = cloned;
            return true;
        }
        else{
            for(int k = 0;k<8;k++){
                newI = i+a[k][0];
                newJ = j+a[k][1];
                if(Valid(newI,newJ,cloned) && tour(c,newI,newJ,cloned)){
                    return true;
                }
            }
            return false;
        }
    }
    public static int[][] clone(int[][] arr){
        int[][] newDp = new int[n][n];
        for(int i=0;i<n;i++){
            newDp[i]=arr[i].clone();
        }
        return newDp;
    }
    public static boolean Valid(int i,int j, int[][] dp){
        if(i>=0 && i<n&&j>=0 && j<n && dp[i][j]==-1){
            return true;
        }
        return false;
    }
    public static void print(){
        if(gdp==null){
            System.out.println("KNIGHT'S TOUR NOT AVAILABLE!");
        }else
        {
            for(int i=0;i<n;i++){
                System.out.println(Arrays.toString(gdp[i]));
            }
        }
    }
}
