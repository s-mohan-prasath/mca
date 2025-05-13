import DP.*;
import backtrack.nqueens;
import backtrack.sumofsubsets;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        exenQueens();
    }
    public static void exenQueens(){
        nqueens nqueens = new nqueens(6);
    }
    public static void exeKnapsack(){
        int n=4,m=5;
        int[] W=new int[]{2,1,3,2},P=new int[]{12,10,20,15};
        zero_one_knapsack dp = new zero_one_knapsack(4,5,W,P);
    }
    public static void exeLCS(){
        longest_common_subsequence dp = new longest_common_subsequence("stone","longest");
    }
    public static void exe_sumofsubsets_backtrack(){
        sumofsubsets dp = new sumofsubsets(new int[]{5,10,12,13,15,18},30);
    }
}