package yuanfudao;

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
