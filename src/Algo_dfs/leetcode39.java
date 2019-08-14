package leetcode.leetcode_DFS;

import java.util.*;

public class leetcode39 {

    public static List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public static int [] path = new int[100];

    public static int len = 0;

    public static void robot(int index, int[] candidates, int target) {
        if (target == 0) {
            // record
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < len; ++i) {
                tmp.add(path[i]);
            }
            ans.add(tmp);
            return;
        }

        // 不满足情况
        if (target < 0 || index >= candidates.length) {
            return;
        }

        // use
        path[len] = candidates[index];
        len++;
        robot(index, candidates, target - candidates[index]);
        len--;

        // not use
        robot(index+1, candidates, target);

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans.clear();
        robot(0, candidates, target);
        return ans;
    }

    public static void main(String [] args) {
        int [] condidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> result = combinationSum(condidates, target);
        System.out.print(result);
    }

}
