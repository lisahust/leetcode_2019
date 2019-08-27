package com_beike;

/**
 * ac 100%
 */


import java.util.Scanner;


public class pro6 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        // n是长度，k是次数
        int len = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();

        String str = sc.nextLine();

        int flag = 0;
        int cur = 0;
        for (int i = 1; i < len; ++i) {
            // flag = 1 代表存在重复子串
            if (str.substring(0,i).equals(str.substring(len-i))) {
                flag = 1;
                cur = i;
            }
        }



        // cur代表重复的个数
        if (flag == 0 || len == 1) {
            String str1 = str;
            for(int i = 1; i < k; ++i) {
                str = str + str1;
            }
        } else if (cur == len){
            // 全部重复
            String str2 = str.substring(len-1);
            for(int i = 1; i < k; ++i) {
                str = str + str2;
            }

        } else {
            String str3 = str.substring(cur);
            for(int i = 1; i < k; ++i) {
                str = str +str3;
            }
        }
        System.out.println(str);
    }
}

