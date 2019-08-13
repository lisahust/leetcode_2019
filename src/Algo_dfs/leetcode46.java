package Algo_dfs;

public class leetcode46 {

    public static int dp(int [][] matrix, int i, int j, int former, int [][] dp) {
        int len = 0;

        if ( i<0 || i > matrix.length-1 || j<0 || j>matrix[0].length-1 || matrix[i][j] <= former ) {
            return len;
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int value = matrix[i][j];
        if (value > former) {
            len++;
        }

        len = Math.max(dp(matrix, i+1, j, value, dp)+1, len);
        len = Math.max(dp(matrix, i-1, j, value, dp)+1, len);
        len = Math.max(dp(matrix, i, j+1, value, dp)+1, len);
        len = Math.max(dp(matrix, i, j-1, value, dp)+1, len);

        dp[i][j] = len;
        return len;
    }

    public static int longestIncreasingPath(int[][] matrix) {
        int ans = 0;
        if(matrix == null || matrix.length == 0) {
            return 0;
        }

        int [][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {

                int value = -1;
                ans = Math.max(dp(matrix, i, j, value, dp), ans);
            }
        }

        return ans;
    }

    public static void main(String [] args) {
        int [][] nums = {{7,8,9}, {9,7,6},{7,2,3}};
        System.out.print(longestIncreasingPath(nums));
    }

}
