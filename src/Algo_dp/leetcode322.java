package Algo_dp;

import java.util.Arrays;

public class leetcode322 {

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        recursion(coins, amount, 0, coins.length - 1);
        return minCount == Integer.MAX_VALUE ? -1 : minCount;
    }
    int minCount = Integer.MAX_VALUE;
    /**
     * 1、按金额从大到小，从多到少（排序，用余数一步到位）
     * 2、预判低于最优解，终止递归（可以返回最优解，不过提升有限，意义不大）
     * 3、能整除即可返回
     */
    void recursion(int[] coins, int amount, int count, int index) {
        if (index < 0 || count + amount / coins[index] >= minCount) return;
        if (amount % coins[index] == 0) {
            minCount = Math.min(minCount, count + amount / coins[index]);
            return;
        }
        for (int i = amount / coins[index]; i >= 0; i--) {
            recursion(coins, amount - i * coins[index], count + i, index - 1);
        }
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amout = 12;
        Arrays.sort(coins);

        leetcode322 solution = new leetcode322();
        System.out.println(solution.coinChange(coins, amout));
    }

}
