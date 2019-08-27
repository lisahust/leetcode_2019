package com_NetEase;

/**
 * 网易提前批第三题
 * 题目描述
 * 小易有一个长度为n的数字数组a1, a2, …, an
 * 问你能够用这n个数字构成一个环（首尾连接），使得环中的每一个数组都小于它相邻的两个数字的和（每个数字都必须使用并且每个数字只能使用一次）
 * 输入描述：
 * 第一行包含一个整数t(1<=t<=10)，表示测试用例的组数。一个整数n，表示数字的个数
 * 第二行n个整数，每两个整数之间用一个空格分隔
 * 输入：
 * 1 5
 * 17 6 17 11 17
 * 输出：
 * YES
 */

import java.util.Arrays;
import java.util.Scanner;

public class pro3 {

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);

        // 第一行包含一个整数t(1<=t<=10)，表示测试用例的组数。一个整数n，表示数字的个数
        int n = sc.nextInt();

        // 第二行n个整数，每两个整数之间用一个空格分隔
        int [] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        if (arr[n-1] >= arr[n-2] + arr[n-3]) {
            System.out.println("no");
        } else {
            System.out.println("yes");
        }

    }
}
