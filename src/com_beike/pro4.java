package com_beike;

import java.util.Scanner;

public class pro4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 第一行是N (1≤n≤5000) ，代表请求队列中的请求数量。
        int N = sc.nextInt();

        // 第二行有N个数字 a1,a2…an  (1≤ai≤10^9)。Ai是第i个请求的负荷值。
        int [] arr = new int[N];
        for (int i = 0; i < N; ++i) {
            arr[i] = sc.nextInt();
        }

        // int max = 0;
        if (N == 1) {
            System.out.print(0);
        }
        if (N == 2) {
            if (arr[0] == arr[1]) {
                System.out.print(1);
            } else {
                System.out.print(0);
            }
        }

        int minResult = 1000000000;
        // 假设峰值在i上

        if (N>=3) {
            for (int i = 0; i < N; ++i) {

                int result = 0;
                // 每一个在i左边的数都要比i小，且递增
                for (int j = i; j >= 1; --j) {
                    int [] findmax  = findMax(arr, 0, j-1);
                    int max = findmax[0];
                    int index = findmax[1];

                    if (arr[j] < max + j - index) {
                        result = result + max + j - index - arr[j];
                        // 将该位数字变为 max + index - j
                        arr[j] = max + j - index;
                    } else {
                        continue;
                    }
                }

                // 每一个在i右边的数都要比i大，且递减
                for (int j = i; j < N-1; ++j) {
                    int [] findmax = findMax(arr, j+1, N-1);
                    int max = findmax[0];
                    int index = findmax[1];

                    if (arr[j] < max + index - j) {
                        result = result + max + index - j - arr[j];
                        // 将该位数字变为 max + index - j
                        arr[i] = max + index - j;
                    } else {
                        continue;
                    }
                }

                minResult = Math.min(result, minResult);
                System.out.println(i + " " + result + " " + minResult);
            }
            System.out.println(minResult);

        }


    }

    public static int[] findMax(int [] arr, int begin, int end) {
        int [] result = new int[2];
        result[0] = arr[begin];
        result[1] = begin;
        for (int i = begin; i < end; ++i) {
            if (arr[i+1] > arr[i]) {
                result[0] = arr[i+1];
                result[1] = i+1;
            }
        }

        return result;
    }
}
