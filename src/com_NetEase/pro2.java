package com_NetEase;

/**
 * 网易提前批第2题
 * 若数组中两数下标和为奇数，则可以交换
 */

import java.util.Arrays;
import java.util.Scanner;

public class pro2 {
    public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);

        // 第一行一个整数n
        int n = sc.nextInt();

        // 第二行n个整数表示数组
        int [] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = sc.nextInt();
        }

        for (int i = 0; i < n-1; ++i) {
            if (array[i]%2 != array[i+1]) {
                Arrays.sort(array);
            }
            break;
        }

        for (int i = 0; i < n; ++i) {
            System.out.print(array[i] + " ");
        }

    }
}
