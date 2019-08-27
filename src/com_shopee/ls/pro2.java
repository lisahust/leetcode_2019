package com_shopee.ls;

/**
 * ac 80%
 * 输入一个数字，从给定数字项（20、10、5、4、2、1）中挑选n次（同一个数字可多次挑选）
 * 要求这n个数字和等于输入数字，求输出n的最小值。
 * 如输入8，输出2
 */

import java.util.Scanner;

public class pro2 {
    public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int [] arr = {20,10,5,4,2,1};

        int res = 0;
        for (int i = 0; i < 6; ++i) {
            if (num < arr[i]) {
                continue;
            } else {
                int count = num / arr[i];
                res = res + count;
                num = num - count * arr[i];
            }
        }


        System.out.print(res);
    }
}
