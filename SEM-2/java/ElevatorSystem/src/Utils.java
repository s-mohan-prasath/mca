public class Utils {
    // --- Utility Functions ---
    public static int MAX(int a, int b) {
        return Math.max(a, b);
    }

    public static int MAX(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static int MIN(int a, int b) {
        return Math.min(a, b);
    }

    public static int MIN(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

}
