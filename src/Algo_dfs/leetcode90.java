package leetcode.leetcode_DFS;

import java.util.*;

public class leetcode90 {
    public static List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public static boolean [] visted = new boolean[100];


    // 连续取，这样可以避免一些情况，避免[0,1]这种情况
    public void robot(int index, int [] nums) {
        // index 代表 nums的第几个
        if (index >= nums.length) {
            // record
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < nums.length; ++i) {
                if (visted[i]) {
                    tmp.add(nums[i]);
                }
            }
            ans.add(tmp);
            return;
        }

        // 当两个数相同，不能出现后面取，前面不取的情况
        if (index > 0 && nums[index-1] == nums[index] && visted[index-1] == false) {
            visted[index] = false;
            robot(index+1, nums);
        } else {
            visted[index] = true;
            robot(index+1, nums);

            visted[index] = false;
            robot(index+1, nums);
        }




    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans.clear();
        int n = nums.length;

        // 交换排序
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (nums[i] > nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }

        robot(0, nums);
        return ans;
    }

}
