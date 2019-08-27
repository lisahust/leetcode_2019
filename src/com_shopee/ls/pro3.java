package com_shopee.ls;

/**
 * ac 20%
 * 字符串计算表达式，用递归计算其正确结果，结果只截取整数部分
 * 要求：字符串中每个数字只能在0-9之间
 * 其余只能包含英文"+" "-" "*" "／" 和小括号 ()
 * 如有其他字符输入，统一输出"ERROR提示"
 * 如"5-1/3+2*8-(4-1)" 输出结果为17
 *
 * 如输入"1+2*3-(5-4)+6/3"
 * 输出8
 */

import java.util.Scanner;
import java.util.Stack;

public class pro3 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        // 首先判断是否有其他字符输入
        for (int i = 0; i < str.length(); ++i) {
            char ch = str.charAt(i);
            if ((ch >= '0' && ch <= '9') || ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '(' || ch == ')') {
                continue;
            } else {
                System.out.print("ERROR");
                return;
            }
        }

        if (str.length() == 3) {
            System.out.print(simpleCal(str));
        } else {
            // calulate
            System.out.print(caculate(str));
        }


    }


    // 计算函数
    public static int caculate(String str) {
        int res = 0;

        // 用两个栈分别保存数字和运算符
        Stack <Integer> numStack = new Stack <> ();
        Stack <Character> signStack = new Stack <> ();
        Stack <Character> tmpStack = new Stack <> ();

        for (int i = 0; i < str.length(); ++i) {
            char ch = str.charAt(i);
            if (ch >= '0' && ch <= '9') {
                numStack.push(str.charAt(i) - '0');
            } else {
                signStack.push(str.charAt(i));
            }
        }

        while (!signStack.isEmpty()) {
            char ch = signStack.pop();
            if (ch == '*' || ch == '/') {
                int num1 = numStack.pop();
                int num2 = numStack.pop();
                if (ch == '*') {
                    numStack.push(num1 * num2);
                } else {
                    numStack.push(num1 / num2);
                }
            }
            if (ch == '+' || ch == '-') {
                int num1 = numStack.pop();
                int num2 = numStack.pop();
                if (ch == '+') {
                    numStack.push(num1 + num2);
                } else {
                    numStack.push(num1 - num2);
                }
            }

        }



        return numStack.pop();
    }

    public static int simpleCal(String str) {
        int num1 = str.charAt(0) - '0';
        int num2 = str.charAt(2) - '0';
        char operator = str.charAt(1);

        if (operator == '+') {
            return num1 + num2;
        } else if (operator == '-') {
            return num1 - num2;
        } else if (operator == '*') {
            return num1 * num2;
        } else if (operator == '/') {
            return num1 / num2;
        }

        return 0;
    }
}
