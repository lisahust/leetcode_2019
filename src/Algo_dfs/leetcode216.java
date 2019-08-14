package leetcode.leetcode_DFS;

import java.util.*;

public class leetcode216 {
    public static List<List<Integer>> ans = new ArrayList<>();

    // 可以用9位的二进制表示选和不选
//    public static boolean [] visited = new boolean[9];
//
//    public static void robot(int index, int n) {
//        if (index >= n) {
//            //record
//            List<Integer> tmp = new ArrayList<>();
//
//            for (int i = 1; i < n; ++i) {
//                if (visited[i]) {
//                    tmp.add(i);
//                }
//            }
//
//            return;
//        }
//
//    }


    public static List<List<Integer>> combinationSum3(int k, int n) {
        ans.clear();
        for (int i = 0; i < (1<<9); ++i) {
            int sum = 0;
            int d = 0;
            for (int j = 1; j <= 9; ++j) {
                if ((i & (1<<(j-1))) > 0) {
                    d++;
                    sum = sum + j;
                }
            }
            if (d == k && sum == n) {
                List<Integer> tmp = new ArrayList<>();
                for (int j = 1; j <= 9; ++j) {
                    if ((i & (1<<j-1)) > 0) {
                        tmp.add(j);
                    }
                }
                ans.add(tmp);
            }
        }
        return ans;
    }

    public static void main(String [] args) {
        combinationSum3(3, 7);
    }

}
