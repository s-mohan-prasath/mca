class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int n = box.length;
        int m = box[0].length;
        char[][] output = new char[m][n];
        int i, j, stones;
        for (i = 0; i < n; i++) {
            j = 0;
            while (j < m) {
                stones = 0;
                while (j < m && box[i][j] != '*') {
                    stones = (box[i][j] == '#') ? stones + 1 : stones;
                    output[j][n - i - 1] = '.';
                    j++;
                }
                if (stones == 0) {
                    if (j != m) {
                        output[j][n - i - 1] = '*';
                    }
                } else {
                    int startI = j;
                    if (j != m && box[i][j] == '*') {
                        output[startI][n - i - 1] = '*';
                    }
                    startI--;
                    while (stones > 0) {
                        output[startI][n - i - 1] = '#';
                        stones--;
                        startI--;
                    }
                }
                j++;
            }
        }
        return output;
    }
}