package leetcode.leetcode_DFS;

import java.util.*;

public class leetcode77 {

    public static List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public static  int[] path = new int[100];

    public static int K = 0;

    // index 属于[0, n] ， index代表最后一个数是多少
    public void robot(int index, int n, int k) {
        // 取k个数
        if (k == 0) {
            // record
            List<Integer> tmp = new ArrayList<Integer>();

            // 因为在循环的时候已经把k给用掉了
            for (int i = 0; i < K; ++i) {
                tmp.add(path[i]);
            }
            ans.add(tmp);
            return;
        }

        for (int i = index+1; i <= n; ++i) {
            // k = 0 时候已经return了
            // 从后往前开始填充
            path[k-1] = i;
            robot(i, n, k-1);
        }

    }

    public List<List<Integer>> combine(int n, int k) {
        ans.clear();
        K = k;
        robot(0, n, k);
        return ans;
    }

}
