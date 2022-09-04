class Solution {

    int length;

    public int movesToChessboard(int[][] board) {
        length = board.length;
        int mv = 0;
        int[][] boardTmp = copy(board);
        int start = getStart(boardTmp);
        boolean match = false;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                match = matchRow(boardTmp[i], boardTmp[j]);
                if (!match) {
                    continue;
                }
                if (i == 0 && start != boardTmp[0][0]) {
                    mvUpDown(boardTmp, i, j);
                } else {
                    if (i + 1 != j) {
                        mvUpDown(boardTmp, i + 1, j);
                    }
                }
                break;
            }
            if (!match) {
                return -1;
            }
        }
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (boardTmp[i][0] != board[i][0]) {
                count++;
            }
        }
        if (length % 2 == 0 && count > length / 2) {
            mv = mv + length - count;
        } else {
            mv += count;
        }
        int[] tmp = copy(boardTmp[0]);
        start = getStart(tmp);
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                match = matchCol(boardTmp, i, j);
                if (!match) {
                    continue;
                }
                if (i == 0 && start != boardTmp[0][0]) {
                    mvLeftRight(boardTmp, i, j);
                } else {
                    if (i + 1 != j) {
                        mvLeftRight(boardTmp, i + 1, j);
                    }
                }
                break;
            }
            if (!match) {
                return -1;
            }
        }
        count = 0;
        for (int i = 0; i < length; i++) {
            if (boardTmp[0][i] != tmp[i]) {
                count++;
            }
        }
        if (length % 2 == 0 && count > length / 2) {
            mv = mv + length - count;
        } else {
            mv += count;
        }
        return mv / 2;
    }

    
    public int[][] copy(int[][] board) {
        int[][] boardTmp = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                boardTmp[i][j] = board[i][j];
            }
        }
        return boardTmp;
    }

    public int[] copy(int[] board) {
        int[] boardTmp = new int[length];
        for (int i = 0; i < length; i++) {
                boardTmp[i] = board[i];
        }
        return boardTmp;
    }

    
    public int getStart(int[] board) {
        if (length % 2 == 0) {
            return board[0];
        }
        int start = 0;
        for (int i = 0; i < length; i++) {
            if (board[i] == 0) {
                start--;
            } else {
                start++;
            }
        }
        return start <= 0 ? 0 : 1;
    }

    public int getStart(int[][] board) {
        if (length % 2 == 0) {
            return board[0][0];
        }
        int start = 0;
        for (int i = 0; i < length; i++) {
            if (board[i][0] == 0) {
                start--;
            } else {
                start++;
            }
        }
        return start <= 0 ? 0 : 1;
    }

    public void mvUpDown(int[][] board, int up, int down) {
        int[] tmp = board[up];
        board[up] = board[down];
        board[down] = tmp;
    }

    public void mvLeftRight(int[][] board, int left, int right) {
        int tmp = 0;
        for (int i = 0; i < length; i++) {
            tmp = board[i][left];
            board[i][left] = board[i][right];
            board[i][right] = tmp;
        }
    }

    public boolean matchRow(int[] source, int[] target) {
        for (int i = 0; i < length; i++) {
            if (source[i] == target[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean matchCol(int[][] board, int source, int target) {
        for (int i = 0; i < length; i++) {
            if (board[i][source] == board[i][target]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // new Solution().movesToChessboard(new int[][]{{1, 0}, {1, 0}});
        // new Solution().movesToChessboard(new int[][]{{1, 0}, {0, 1}});
        // new Solution().movesToChessboard(new int[][]{{0,1,1,0,0}, {0,1,1,0,0}, {1,0,0,1,1}, {0,1,1,0,0}, {1,0,0,1,1}});
        // new Solution().movesToChessboard(new int[][]{{1,0,0 }, { 0,1,1 }, { 1,0,0}});
        // new Solution().movesToChessboard(new int[][]{{0,0,1,1}, { 1,1,0,0}, { 0,1,0,1}, { 1,0,1,0}});
        // new Solution().movesToChessboard(new int[][]{{1,1,0}, {0,0,1 }, {0,0,1}});
        // new Solution().movesToChessboard(new int[][]{{0,1,1}, {1,0,0}, {1,0,0}});
        // new Solution().movesToChessboard(new int[][]{{1,1,0,0,1,0,0}, {0,0,1,1,0,1,1}, {1,1,0,0,1,0,0}, {0,0,1,1,0,1,1}, {1,1,0,0,1,0,0}, {0,0,1,1,0,1,1}, {0,0,1,1,0,1,1}});
        // new Solution1().movesToChessboard(new int[][]{{1,1,0,1,0,0,1,0,1,0,1},{1,1,0,1,0,0,1,0,1,0,1},{0,0,1,0,1,1,0,1,0,1,0},{0,0,1,0,1,1,0,1,0,1,0},{0,0,1,0,1,1,0,1,0,1,0},{1,1,0,1,0,0,1,0,1,0,1},{0,0,1,0,1,1,0,1,0,1,0},{1,1,0,1,0,0,1,0,1,0,1},{0,0,1,0,1,1,0,1,0,1,0},{1,1,0,1,0,0,1,0,1,0,1},{1,1,0,1,0,0,1,0,1,0,1}});
        
        // new Solution().movesToChessboard(new int[][]{{1,1,1,1}, {1,1,1,1}, {0,0,0,0}, {0,0,0,0}});
        new Solution().movesToChessboard(new int[][]{{0,0,1,0,1,1},{1,1,0,1,0,0},{1,1,0,1,0,0},{0,0,1,0,1,1},{1,1,0,1,0,0},{0,0,1,0,1,1}});
        
    }

}