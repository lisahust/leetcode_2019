package Algo_dp;

/*
未跑通
 */

public class bag0_1 {
    int W;
    int f[][];
    int w[];
    int v[];
    int n;

    // 自顶向下
    int search(int index, int S) {
        if (S > W) {
            return 0;
        }
        if (index >= n) {
            return 0;
        }
        if (f[index][S] >= 0) {
            return f[index][S];
        }

        f[index][S] = Math.max(search(index+1, S+w[index]) + v[index], search(index+1, S));
        return f[index][S];
    }

    // 自底向上
    int search2(int index, int S) {
        f[index][0] = 0;
        for (int j = 1; j <= W; ++j) {
            f[index][j] = Math.max(f[index-1][j-w[index]] + v[index], f[index-1][j] );
        }

        return f[index][S];
    }

}
