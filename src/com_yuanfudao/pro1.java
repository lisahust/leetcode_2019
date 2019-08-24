package com_yuanfudao;

import java.util.*;

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
