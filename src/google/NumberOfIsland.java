package src.google;

/*@DFS
 * leetcode: 200 Number of islands
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *solution:
 * use dfs
 *1. to iterate each pixel and do dfs to each pixel which value is '1', when dfs to each pixel make that to '*'
 * 2. when meet the bound or < 0 or grid[][] != '1' return
 *
 *
 * */

public class NumberOfIsland {

    private int m;
    private int n;

    public int numIslands(char[][] grid) {
        m = grid.length;
        if (m == 0) return 0;
        int res = 0;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != '1') return;
        grid[i][j] = '*';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
        return;
    }
}
