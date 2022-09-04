class Solution {

    public int numSpecial(int[][] mat) {
        int ans = 0;
        int m = mat.length, n = mat[0].length;
        int[] rowArr = new int[m];
        int[] colArr = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    continue;
                }
                if (rowArr[i] == 1 || colArr[j] == 1) {
                    continue;
                }
                if (check(mat, i, j)) {
                    ans++;
                    rowArr[i] = 1;
                    colArr[j] = 1;
                }
            }
        }
        return ans;
    }

    public boolean check(int[][] mat, int row, int col) {
        int m = mat.length, n = mat[0].length;
        for (int i = 0; i < n; i++) {
            if(i != col && mat[row][i] == 1) {
                return false;
            }
        }
        for (int i = 0; i < m; i++) {
            if(i != row && mat[i][col] == 1) {
                return false;
            }
        }
        return true;
    }

}