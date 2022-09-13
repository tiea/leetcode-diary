class Solution {

    char[][] board;
    char[] chars;
    int m, n;
    int[][] history;
    int len;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        m = board.length;
        n = board[0].length;
        history = new int[m][n];
        chars = word.toCharArray();
        len = chars.length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char cur = board[i][j];
                int pos = 0;
                if (cur == chars[pos]) {
                    boolean result = search(i, j, 0);
                    if (result) {
                        return true;
                    }
                }
            }
        }
        return false;

    }

    public boolean search(int row, int col, int pos) {
        if (pos == len - 1) {
            return true;
        }
        history[row][col] = 1;
        boolean result = false;
        if (row > 0 && board[row - 1][col] == chars[pos + 1] && history[row - 1][col] == 0) {
            result = result || search(row - 1, col, pos + 1);
        }
        if (col < n - 1 && board[row][col + 1] == chars[pos + 1] && history[row][col + 1] == 0) {
            result = result || search(row, col + 1, pos + 1);
        }
        if (row < m - 1 && board[row + 1][col] == chars[pos + 1] && history[row + 1][col] == 0) {
            result = result || search(row + 1, col, pos + 1);
        }
        if (col > 0 && board[row][col - 1] == chars[pos + 1] && history[row][col - 1] == 0) {
            result = result || search(row, col - 1, pos + 1);
        }
        history[row][col] = 0;
        return result;
    }

    public static void main(String[] args) {
        new Solution().exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED");
    }

}