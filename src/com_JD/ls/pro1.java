package com_JD.ls;

/**
 * ac 100%
 * 题目描述：
 * 合唱队的N名学生站成一排且从左到右编号为1到N，其中编号为i的学生身高为Hi。现在将这些学生分成若干组（同一组的学生编号连续），并让每组学生从左到右按身高从低到高进行排列，使得最后所有学生同样满足从左到右身高从低到高（中间位置可以等高），那么最多能将这些学生分成多少组？
 *
 * 输入
 * 第一行包含一个整数N，1≤N≤105。
 *
 * 第二行包含N个空格隔开的整数H1到HN，1≤Hi≤109。
 *
 * 输出
 * 输出能分成的最多组数。
 *
 *
 * 样例输入
 * 4
 * 2 1 3 2
 * 样例输出
 * 2
 *
 * 提示
 * 补充样例
 * 输入样例2
 * 10
 * 69079936 236011312 77957850 653604087 443890802 277126428 755625552 768751840 993860213 882053548
 * 输出样例2
 * 6
 *
 * 此时分组为：【69079936】【236011312 77957850】【653604087 443890802 277126428】 【755625552】 【768751840】【 993860213 882053548】调整顺序后即可满足条件
 */

import java.util.Arrays;
import java.util.Scanner;

public class pro1 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int [] height = new int[N];
        int [] heightCopy = new int[N];
        for (int i = 0; i < N; ++i) {
            height[i] = sc.nextInt();
            heightCopy[i] = height[i];
        }

        Arrays.sort(heightCopy);
        int result = 0;
        int start = 0;
        for (int i = 0; i < N; ++i) {
//            System.out.print(heightCopy[i] + "  ");
//            System.out.println(max(height, start, i));
            if (heightCopy[i] == max(height, start, i)) {
                result++;
                start = i+1;
            } else {
            }
        }
        System.out.print(result);

    }

    public static int max(int[] array, int start, int end) {
        int res = array[start];
        for (int i = start; i <= end; ++i) {
            if (array[i] > res) {
                res = array[i];
            }
        }
        return res;
    }

}
