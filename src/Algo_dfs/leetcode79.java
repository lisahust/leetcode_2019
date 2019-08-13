package Algo_dfs;

public class leetcode79 {
    public static boolean [][] visited = new boolean[200][200];

    public static boolean robot(char[][] board, String word, int i, int j, int index) {

        // index表示string的第几个元素, index移动到word.length()时表示前面的所有都找到了
        if (index == word.length())  {
            return true;
        }

        // false的结束条件
        if (i < 0 || i > board.length-1 || j < 0 || j > board[0].length-1 || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }

        if (board[i][j] == word.charAt(index) && !visited[i][j]) {
            index++;
            visited[i][j] = true;
        }

        boolean ans = robot(board, word, i+1, j, index) ||  robot(board, word, i-1, j, index) || robot(board, word, i, j+1, index) || robot(board, word, i, j-1, index);

        visited[i][j] = false;
        return ans;

    }

    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (robot(board, word, i, j, 0)) {

                    // 清空visited
                    for (int m = 0; m < board.length; ++m) {
                        for (int n = 0; n < board[0].length; ++n){
                            visited[m][n] = false;
                        }
                    }

                    if (robot(board, word, i, j, 0)) {
                        return true;
                    }
                }

            }
        }
        return false;
    }

    public static void main(String [] args) {
        char[][] board = {{'a'}};
        String word = "a";
        System.out.println(exist(board, word));
    }

}
