package com_yuanfudao;

import java.util.Scanner;
import java.util.Stack;

/**
 * 猿辅导提前批第一题
 * 题目描述：
 * 猿辅导APP需要下发一些宣传文本给学生，工程师们使用了一种字符压缩算法，为简单起见，假设被罚锁的字符全部为大写字母序列，A, B, C, D … Z，压缩规则如下：
 * 1. AAAB可以压缩为A3B（单字符压缩不加括号）
 * 2. ABABA可以压缩为(AB)2A（多字符串压缩才加括号）
 *
 * 输入描述：
 * (AB)3A3
 *
 * 输出描述：
 * ABABABAAA
 */

public class pro1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 正整数C
        int C = sc.nextInt();
        sc.nextLine();

        // 存字符串数组
        String[] strArr = new String[C];
        for (int i = 0; i < C; ++i) {
            strArr[i] = sc.nextLine();
        }

        // 处理字符串数组
        for (int i = 0; i < C; ++i) {
            String str = strArr[i];
            decompression(str);
        }

    }

    public static void decompression(String str) {
        char[] chars = str.toCharArray();
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < chars.length; ) {
            char elem = chars[i];
            if (elem == '(') {
                stack.push(String.valueOf(elem));
                i++;
                continue;
            }
            if (elem == ')') {
                String leftBrace = "(";
                String tmp = "";
                String pop;
                while (!stack.isEmpty() && !(pop = stack.pop()).equals(leftBrace)) {
                    tmp = pop + tmp;
                }
                stack.push(tmp);
                i++;
                continue;
            }
            if (elem >= 'A' && elem <= 'Z') {
                stack.push(String.valueOf(elem));
                i++;
                continue;
            }
            if (elem >= '0' && elem <= '9') {
                String tmp = "";
                while (i < chars.length && chars[i] >= '0' && chars[i] <= '9') {
                    tmp = tmp + chars[i++];
                }
                int n = Integer.valueOf(tmp);
                String repeat = stack.pop();
                String tmp1 = "";
                for (int j = 0; j < n; j++) {
                    tmp1 += repeat;
                }
                stack.push(tmp1);
                continue;
            }
        }
        String tmp = "";
        while (!stack.isEmpty()) {
            tmp = stack.pop() + tmp;
        }
        System.out.println(tmp);
    }
}
