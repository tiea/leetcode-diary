class Solution {

    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int length = m * n;
        int[] ans = new int[length];
        int x = 0, y = 0, ptr = 0;
        boolean up = true;
        while (ptr < length) {
            ans[ptr] = mat[x][y];
            ptr++;
            if (up) {
                if (y == n - 1) {
                    // to down
                    x = x + 1;
                    up = false;
                } else if (x == 0) {
                    // to right
                    y = y + 1;
                    up = false;
                } else {
                    x = x - 1;
                    y = y + 1;
                }
            } else {
                if (x == m - 1) {
                    // to right
                    y = y + 1;
                    up = true;
                } else if (y == 0) {
                    // to down
                    x = x + 1;
                    up = true;
                } else {
                    x = x + 1;
                    y = y - 1;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new Solution().findDiagonalOrder(new int[][]{{2,3}});
    }

}