import DP.*;
public class Main {
    public static void main(String[] args) {
        exeLCS();
    }
    public static void exeKnapsack(){
        int n=4,m=5;
        int[] W=new int[]{2,1,3,2},P=new int[]{12,10,20,15};
        zero_one_knapsack dp = new zero_one_knapsack(4,5,W,P);
    }
    public static void exeLCS(){
        longest_common_subsequence dp = new longest_common_subsequence("stone","longest");
    }
}