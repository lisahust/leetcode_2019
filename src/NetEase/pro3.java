package NetEase;

/**
 * 网易提前批第三题
 */

import java.util.*;

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
