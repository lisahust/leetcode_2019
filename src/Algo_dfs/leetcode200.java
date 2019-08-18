package Algo_dfs;

/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 */

import java.util.*;

public class leetcode200 {

    public static void dfs(char[][] grid, int i, int j, boolean [][] visited) {
        if (i < 0 || i > grid.length-1 || j < 0 || j > grid[0].length-1 || visited[i][j]) {
            return;
        }
        if (grid[i][j] == '0') {
            return;
        }
        if (grid[i][j] == '1') {
            visited[i][j] = true;
            dfs(grid, i+1, j, visited);
            dfs(grid, i-1, j, visited);
            dfs(grid, i, j-1, visited);
            dfs(grid, i, j+1, visited);
        }
    }

    public static int numIslands(char[][] grid) {
        int result = 0;
        if (grid == null || grid.length==0) {
            return 0;
        }
        boolean [][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfs(grid, i, j, visited);
                    result++;
                }
            }
        }

        return result;
    }

    public static void main(String [] args) {
        char[][] grid = {{'1','1','1','1','0'}, {'1','1','0','1','0'}, {'1','1','0','0','0'}, {'0','0','0','0','0'}};
        System.out.println(numIslands(grid));
    }
}
