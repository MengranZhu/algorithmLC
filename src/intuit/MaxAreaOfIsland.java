package src.intuit;

import src.tag.DFS;

/*leetcode 695. Max Area of Island
* Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's
* (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
* solution :
* similar with numbers of islands set two global values res and current temp
*
* */
@DFS
public class MaxAreaOfIsland {
    private int res = 0;
    private int temp;

    public int maxAreaOfIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    temp = 0;
                    dfs(grid, i, j);
                    res = Math.max(res, temp);
                }
            }
        }
        return res;
    }

    public void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) return;
        temp++;
        grid[i][j] = 0;
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
        return;
    }
}
