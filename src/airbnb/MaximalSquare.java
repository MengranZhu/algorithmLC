package src.airbnb;

import src.tag.DP;

/*
 * leetcode: 221. Maximal Square
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 *solution: DP set a 2-D dp matrix. DP[i][j] means at matrix[i][j] the dp(i, j) represents the length of the square
 * so when matrix[i-1][j-1] == '1' dp[i][j] = min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1]) + 1;
 * find the Math.max(max and dp[i][j])
 *return max*max;
 * */
@DP
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int res = 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res * res;
    }
}
