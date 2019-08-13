package yuanfudao;

import java.util.*;

public class pro3 {
    public static int robot(int[][] matrix, int i, int j, int len, int former, int click) {
        int maxLen = 0;
        if ( i<0 || i > matrix.length-1 || j<0 || j>matrix[0].length-1 || (matrix[i][j] <= former && click == 0) ) {
            return len;
        }

        int value = matrix[i][j];
        len = len+1;

        // 可以不用紧急按钮
        if (value > former) {
            maxLen = Math.max(robot(matrix, i+1, j, len, value, click), maxLen);
            maxLen = Math.max(robot(matrix, i-1, j, len, value, click), maxLen);
            maxLen = Math.max(robot(matrix, i, j+1, len, value, click), maxLen);
            maxLen = Math.max(robot(matrix, i, j-1, len, value, click), maxLen);
        } else {
            // 用紧急按钮
            maxLen = Math.max(robot(matrix, i+1, j, len, value, click-1), maxLen);
            maxLen = Math.max(robot(matrix, i-1, j, len, value, click-1), maxLen);
            maxLen = Math.max(robot(matrix, i, j+1, len, value, click-1), maxLen);
            maxLen = Math.max(robot(matrix, i, j-1, len, value, click-1), maxLen);
        }

        return maxLen;
    }

    public static int longestIncreasingPath(int[][] matrix) {
        int ans = 0;
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                int len = 0;
                int value = -1;
                int click = 1;
                ans = Math.max(robot(matrix, i, j, len, value, click), ans);
            }
        }

        return ans;
    }

    public static void main(String [] args) {
        int [][] nums = {{1,3,3}, {2,4,9},{8,9,2}};
        System.out.print(longestIncreasingPath(nums));
    }
}
