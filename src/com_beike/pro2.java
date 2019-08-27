package com_beike;

import java.util.Arrays;
import java.util.Scanner;

public class pro2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[n];
        int len = 0;
        for(int num : arr) {
            // 二分找位置
            int i = Arrays.binarySearch(dp, 0, len, num);
            // 找不到新增
            i = i < 0 ? -(i + 1) : i;
            dp[i] = num;
            len = i == len ? (++len) : len;
        }
        System.out.println(len);
    }
}
