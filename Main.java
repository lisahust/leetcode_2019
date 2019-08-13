import java.util.*;

public class Main {

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

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dfs(i, j, K, 1, N, M, matrix);
            }
        }


        System.out.println(max);


    }

    public static void dfs(int i, int j, int k, int step, int n, int m, int[][] matrix) {
        if (i >= n || i < 0 || j >= m || j < 0) {
            max = Math.max(step, max);
            return;
        }
        if (i + 1 < n && matrix[i + 1][j] > matrix[i][j]) {
            dfs(i + 1, j, k, step + 1, n, m, matrix);
        }
        else if (i + 1 < n && matrix[i + 1][j] <= matrix[i][j]&&k>0) {
            dfs(i + 1, j, k-1, step + 1, n, m, matrix);
        }
        if (i - 1 >= 0 && matrix[i - 1][j] <= matrix[i][j] && k > 0) {
            dfs(i - 1, j, k - 1, step + 1, n, m, matrix);
        }
        else if (i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j] ) {
            dfs(i - 1, j, k , step + 1, n, m, matrix);
        }
        if (j + 1 < m && matrix[i][j + 1] > matrix[i][j]) {
            dfs(i, j + 1, k, step + 1, n, m, matrix);
        }
        else if (j + 1 < m && matrix[i][j + 1] <=matrix[i][j]&&k>0) {
            dfs(i, j + 1, k-1, step + 1, n, m, matrix);
        }
        if (j - 1 >= 0 && matrix[i][j - 1] <= matrix[i][j] && k > 0) {
            dfs(i, j - 1, k - 1, step + 1, n, m, matrix);
        }
        else if (j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j] ) {
            dfs(i, j - 1, k , step + 1, n, m, matrix);
        }
        max = Math.max(step, max);
    }

}