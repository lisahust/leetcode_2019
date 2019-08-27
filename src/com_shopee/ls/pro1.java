package com_shopee.ls;

/**
 * ac 20%
 * 1-a,b,c
 * 2-d,e,f
 * 3-g,h,i
 * 4-j,k,l
 * 5-m,n,o
 * 6-p,q,r
 * 7-s,t,u
 * 8-v,w,x
 * 9-y,z
 * 现在给出一个只包含1-9的点按序列，返回所有可能的映射组合，以字典序输出
 * 输入 1 3
 * 输出 ag ah ai bg bh bi cg ch ci
 */

import java.util.Scanner;

public class pro1 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int num1 = str.charAt(0) - '0';
        int num2 = str.charAt(1) - '0';

        String [][] array = {{"a","b","c"},{"d","e","f"},{"g","h","i"},{"j","k","l"},{"m","n","o"},{"p","q","r"},{"s","t","u"},{"v","w","x"},{"y","z"}};
        String [][] result = new String[3][3];

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                result[i][j] = array[num1-1][i] + array[num2-1][j];
            }
        }

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                System.out.print(result[i][j] + " ");
            }
        }


    }

}
