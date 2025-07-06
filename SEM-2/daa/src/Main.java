import DP.*;
import backtrack.nqueens;
import backtrack.sumofsubsets;
import divide_and_conquer.*;

import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        System.out.println((int) (Math.random() * 10));
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
    public static void exe_mergeSort(){
        int[] a = new int[]{5,4,0,-1,10,-10};
        merge_sort mergeSort = new merge_sort(6,a);
        System.out.println(Arrays.toString(a));
    }
    public static void exe_quickSort(){
        int[] a = new int[]{1,2,3,4,5,6,7};
        new quick_sort(a);
    }
}