import java.util.*;

public class Solution {

    public static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 第一行输入三个数 N, M, K  (N*M矩阵，按钮只能按K次)
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        int [][] matrix = new int[N][M];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println(max);


    }

}