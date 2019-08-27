package com_yuanfudao;

/**
 * 猿辅导提前批笔试第二题
 * 迷宫
 * 题目表述
 *   有一个N*M大小的迷宫矩阵，迷宫的每一个格子有一个数值（a[i][j]<10^9）。小猿在迷宫中发现，它只能朝着上下左右四个方向的相邻格子前进，并且只能进入比当前位置数值更大的格子。但是小猿有一个紧急呼叫按钮，他可以通过按下按钮，强行进入到不满足数值大小要求的相邻格子。可惜这个按钮只能按K次。请问小猿从这个迷宫任选一个格子出发，在紧急呼救按钮的帮助下，最多能走多少步（开始位置计入步数，即站在起点是步数为1）。
 *   输入描述：
 *   3 3 1
 *   1 3 3
 *   2 4 9
 *   8 9 2
 *   输出描述：
 *   6
 *   （1-2-4-9-2-9）
 */

public class pro2 {
    public static void main(String[] args) {

        int[][] nums = {{1,3,3},{2,4,9},{8,9,2}};
        int k = 1;

        pro2 pro2 = new pro2();

        System.out.println(pro2.getMaxStepNumber(nums, k));
    }

    public int getMaxStepNumber(int[][] nums, int k) {

        int[][][] dp = new int[nums.length][nums[0].length][k + 1];// 已经初始化为0了
        int ans = -1;

        //开始从K等于0开始，动态规划计算每一步的大小
        for (int i = 0; i < nums.length; i++) {

            for (int j = 0; j < nums[0].length; j++) {

                for (int nowK = 0; nowK <= k; nowK++) {
                    getMaxHelper(nums, i, j, nowK, dp);
                    if (ans < dp[i][j][nowK]) ans = dp[i][j][nowK];
                }

            }
        }
        return ans;
    }

    private void getMaxHelper(int[][] nums, int i, int j, int k, int[][][] dp) {

        if (dp[i][j][k] != 0) return;

        int upDistance = -1, downDistance = -1, leftDistance = -1, rightDistance = -1;

        //判断上方的点
        if (i > 0) {
            if (nums[i][j] <= nums[i - 1][j]) {
                //当前位置比上方位置的数字小
                upDistance = k == 0? 1 : 1 + dp[i - 1][j][k - 1];
            }
            else {
                //当前位置比上方位置的数字大
                getMaxHelper(nums, i - 1, j, k, dp);
                upDistance = 1 + dp[i - 1][j][k];
            }
        }

        //判断下方的点
        if (i < nums.length - 1) {
            if (nums[i][j] <= nums[i + 1][j]) {
                //当前位置比下方位置的数字小
                downDistance = k == 0? 1 : 1 + dp[i + 1][j][k - 1];
            }
            else {
                //当前位置比上方位置的数字大
                getMaxHelper(nums, i + 1, j, k, dp);
                downDistance = 1 + dp[i + 1][j][k];
            }
        }

        //判断左边的点
        if ( j > 0) {
            if (nums[i][j] <= nums[i][j - 1]) {
                //当前位置比下方位置的数字小
                leftDistance = k == 0? 1 : 1 + dp[i][j - 1][k - 1];
            }
            else {
                //当前位置比上方位置的数字大
                getMaxHelper(nums, i, j - 1, k, dp);
                leftDistance = 1 + dp[i][j - 1][k];
            }
        }

        //判断右边的点
        if ( j < nums[0].length - 1) {
            if (nums[i][j] <= nums[i][j + 1]) {
                //当前位置比下方位置的数字小
                rightDistance = k == 0? 1 : 1 + dp[i][j + 1][k - 1];
            }
            else {
                //当前位置比上方位置的数字大
                getMaxHelper(nums, i, j + 1, k, dp);
                rightDistance = 1 + dp[i][j + 1][k];
            }
        }

        //给dp结果数组赋值
        int max = Math.max(upDistance, downDistance);
        max = Math.max(max, leftDistance);
        max = Math.max(max, rightDistance);
        dp[i][j][k] = max;
    }

}

class pro2_2 {
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
