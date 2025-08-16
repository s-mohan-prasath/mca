import java.util.*;

public class MatrixVectorMultiplication {
    static class Worker extends Thread {
        int row;
        int[] rowVector;
        int[] vector;
        int[] result;

        Worker(int row, int[] rowVector, int[] vector, int[] result) {
            this.row = row;
            this.rowVector = rowVector;
            this.vector = vector;
            this.result = result;
        }

        public void run() {
            int sum = 0;
            for (int j = 0; j < vector.length; j++) {
                sum += rowVector[j] * vector[j];
            }
            result[row] = sum;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int[] vector = {1, 2, 3};
        int[] result = new int[matrix.length];

        Thread[] threads = new Thread[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            threads[i] = new Worker(i, matrix[i], vector, result);
            threads[i].start();
        }

        for (Thread t : threads) t.join();

        System.out.println("Result:");
        for (int val : result) System.out.print(val + " ");
    }
}
public class MatrixTranspose {
    static class Transposer extends Thread {
        int row;
        int[][] matrix;
        int[][] transposed;

        Transposer(int row, int[][] matrix, int[][] transposed) {
            this.row = row;
            this.matrix = matrix;
            this.transposed = transposed;
        }

        public void run() {
            for (int j = 0; j < matrix[0].length; j++) {
                transposed[j][row] = matrix[row][j];
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6}
        };

        int[][] transposed = new int[matrix[0].length][matrix.length];
        Thread[] threads = new Thread[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            threads[i] = new Transposer(i, matrix, transposed);
            threads[i].start();
        }

        for (Thread t : threads) t.join();

        System.out.println("Transposed Matrix:");
        for (int[] row : transposed) {
            for (int val : row) System.out.print(val + " ");
            System.out.println();
        }
    }
}
public class MaxFinder {
    static class Worker extends Thread {
        int[] data;
        int start, end;
        int localMax = Integer.MIN_VALUE;

        Worker(int[] data, int start, int end) {
            this.data = data;
            this.start = start;
            this.end = end;
        }

        public void run() {
            for (int i = start; i < end; i++) {
                if (data[i] > localMax) localMax = data[i];
            }
        }

        public int getLocalMax() {
            return localMax;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int[] data = {10, 25, 30, 5, 90, 70, 55, 65};
        int numThreads = 4;
        Worker[] workers = new Worker[numThreads];
        int chunk = data.length / numThreads;

        for (int i = 0; i < numThreads; i++) {
            int start = i * chunk;
            int end = (i == numThreads - 1) ? data.length : start + chunk;
            workers[i] = new Worker(data, start, end);
            workers[i].start();
        }

        int globalMax = Integer.MIN_VALUE;
        for (Worker w : workers) {
            w.join();
            globalMax = Math.max(globalMax, w.getLocalMax());
        }

        System.out.println("Maximum value: " + globalMax);
    }
}
public class CharFrequency {
    static class Worker extends Thread {
        String chunk;
        int[] localFreq = new int[26];

        Worker(String chunk) {
            this.chunk = chunk.toLowerCase();
        }

        public void run() {
            for (char c : chunk.toCharArray()) {
                if (c >= 'a' && c <= 'z') {
                    localFreq[c - 'a']++;
                }
            }
        }

        public int[] getLocalFreq() {
            return localFreq;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String input = "Parallel Processing With Java Threads Is Fun!";
        int numThreads = 4;
        int length = input.length();
        Worker[] workers = new Worker[numThreads];

        for (int i = 0; i < numThreads; i++) {
            int start = i * length / numThreads;
            int end = (i == numThreads - 1) ? length : (i + 1) * length / numThreads;
            workers[i] = new Worker(input.substring(start, end));
            workers[i].start();
        }

        int[] globalFreq = new int[26];
        for (Worker w : workers) {
            w.join();
            int[] local = w.getLocalFreq();
            for (int i = 0; i < 26; i++) {
                globalFreq[i] += local[i];
            }
        }

        System.out.println("Character Frequencies:");
        for (int i = 0; i < 26; i++) {
            System.out.printf("%c: %d\n", (char)('a' + i), globalFreq[i]);
        }
    }
}