public class Recursion {
    private long[] dp;

    public Recursion() {

    }

    public long frogJump(int[] arr) {
        int n = arr.length;
        dp = new long[n + 1];
        return f2(n - 1, arr);
    }

    public long frogKJumps(int k, int[] arr) {
        int n = arr.length;
        dp = new long[n + 1];
        return f3(n - 1, k, arr);
    }

    public long climbStairs(int n) {
        dp = new long[n + 1];
        return f1(n);
    }

    private long f3(int n, int k, int[] arr) {
        if (n == 0)
            return 0;
        else {
            if (dp[n] != 0)
                return dp[n];
            else {
                dp[n] = Integer.MAX_VALUE;
                for (int i = 1; i <= k; i++) {
                    if (n - i < 0)
                        break;
                    else {
                        dp[n] = Math.min(f3(n - i, k, arr) + Math.abs(arr[n] - arr[n - i]), dp[n]);
                    }
                }
                return dp[n];
            }
        }
    }

    private long f2(int n, int[] arr) {
        if (n == 0)
            return 0;
        else {
            if (dp[n] != 0) {
                return dp[n];
            }
            long left = f2(n - 1, arr) + Math.abs(arr[n] - arr[n - 1]);
            long right = Integer.MAX_VALUE;
            if (n > 1) {
                right = f2(n - 2, arr) + Math.abs(arr[n] - arr[n - 2]);
            }
            dp[n] = Math.min(left, right);
            return dp[n];
        }
    }

    private long f1(int n) {
        if (n == 0)
            return 1;
        else if (n < 0)
            return 0;
        else {
            if (dp[n] != 0)
                return dp[n];
            else {
                dp[n] = f1(n - 1) + f1(n - 2);
                return dp[n];
            }
        }
    }
}
