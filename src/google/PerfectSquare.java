package src.google;

/*
* Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
* solution: this is a classical dp problem
* one dimension dp
* 1. create a dp solution table
* 2. find the pattern
* dp[0] = 0;
* dp[1] = 1;
* dp[2] = 2 => dp[2 - 1*1] + 1
*dp[3] = 3 => dp[3 - 1*1] + 1
*dp[4] = 1 => min(dp[4 - 1*1] + 1, dp[4 - 2*2] + 1) => 1
*
* so dp[n] = min(dp[n - 1*1] + 1, dp[n - 2*2] + 1....
* */

import java.util.Arrays;

public class PerfectSquare {

    public int numSquares(int n) {
        int[] res = new int[n + 1];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;
        res[1] = 1;
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            int j = 1;
            while (i - j * j >= 0) {
                min = Math.min(res[i - j * j] + 1, min);
                j++;
            }

            res[i] = min;
        }
        return res[n];


    }
}
