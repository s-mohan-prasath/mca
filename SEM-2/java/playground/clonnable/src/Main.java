//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[][] dp = {{1,2,3}};
        int[][] dp2 = new int[dp.length][dp[0].length];
        for (int i = 0; i < dp.length; i++) {
            dp2[i] = dp[i].clone();
        }
        dp[0][0] = 100;
        System.out.println(dp2[0][0]);
    }
}