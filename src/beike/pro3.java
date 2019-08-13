package beike;

import java.util.*;

public class pro3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 第一行N，表示参赛人数（2<=N<=10^5）
        int N = sc.nextInt();

        // 第二行N个正整数表示体重（0<体重<=10^8）
        int [] arr = new int[N];
        for (int i = 0; i < N; ++i) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int result = 0;
        for (int i = 0; i < N-1; ++i) {
            for (int j = i+1; j < N; ++j) {
                if (arr[i] >= arr[j] * 0.9 ) {
                    result++;
                }else {
                    break;
                }
            }
        }

        System.out.print(result);

    }

}
