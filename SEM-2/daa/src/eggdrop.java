public class eggdrop {

    public static int eggDropDP(int n, int e) {
        int[][] dp = new int[n + 1][e + 1];  // dp[n][e]: floors as rows, eggs as columns

        // Step 1: Initialize base cases
        for (int i = 1; i <= n; i++) {
            dp[i][1] = i;  // With 1 egg, we need i drops for i floors
        }

        for (int j = 1; j <= e; j++) {
            dp[0][j] = 0;  // 0 floors = 0 trials
            dp[1][j] = 1;  // 1 floor = 1 trial
        }

        // Step 2: Fill the DP table
        for (int i = 2; i <= n; i++) {        // Floors
            for (int j = 2; j <= e; j++) {    // Eggs
                dp[i][j] = Integer.MAX_VALUE;

                for (int x = 1; x <= i; x++) {
                    int breakCase = dp[x - 1][j - 1];   // Egg breaks
                    int noBreakCase = dp[i - x][j];     // Egg doesn't break
                    int worst = 1 + Math.max(breakCase, noBreakCase);

                    dp[i][j] = Math.min(dp[i][j], worst);
                }
            }
        }

        return dp[n][e];
    }

    public static void main(String[] args) {
        int floors = 10;
        int eggs = 2;
        int minAttempts = eggDropDP(floors, eggs);

        System.out.println("Minimum attempts needed with " + eggs + " eggs and " + floors + " floors: " + minAttempts);
    }
}
