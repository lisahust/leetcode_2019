package Algo_dp;

public class leetcode198 {
    public static int[] dpResult;

    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        dpResult = new int[nums.length];
        dpResult[0] = nums[0];
        dpResult[1] = Math.max(nums[0], nums[1]);

        for (int index = 2; index < nums.length; ++index) {
            dpResult[index] = Math.max(dpResult[index-1], dpResult[index-2] + nums[index]);
        }

        return dpResult[nums.length-1];
    }

    public static void main(String [] args) {
        int [] nums = {2,7,9,3,1};
        System.out.println(rob(nums));
    }
}
