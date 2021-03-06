package src.microsoft;

/*
* leetcode: 48. Rotate Image
*You are given an n x n 2D matrix representing an image.

 Rotate the image by 90 degrees (clockwise).
* * clockwise rotate
 * first reverse up to down, then swap the symmetry
 * 1 2 3     7 8 9     7 4 1
 * 4 5 6  => 4 5 6  => 8 5 2
 * 7 8 9     1 2 3     9 6 3
*
*
*
* */
public class RotateImage {
    public void rotate(int[][] matrix) {
        if (matrix.length == 0 && matrix == null) return;
        int n = 0;
        int m = matrix.length - 1;
        while (n < m) {
            int[] temp = matrix[n];
            matrix[n] = matrix[m];
            matrix[m] = temp;
            n++;
            m--;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
