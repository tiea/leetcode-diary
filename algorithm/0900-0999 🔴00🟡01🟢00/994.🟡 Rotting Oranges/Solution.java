import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

class Solution {

    boolean isFresh = false;
    int m, n;

    public int orangesRotting(int[][] grid) {
        Queue<Position> queue = new LinkedBlockingQueue<>();
        initFindRotting(grid, queue);
        int minute = 0;
        if (queue.isEmpty()) {
            return isFresh ? -1 : minute;
        }
        isFresh = false;
        while (!queue.isEmpty()) {
            Queue<Position> tmp = new LinkedBlockingQueue<>();
            do {
                Position pos = queue.poll();
                Position top = getTop(grid, pos);
                if (top != null) {
                    tmp.add(top);
                }
                Position left = getLeft(grid, pos);
                if (left != null) {
                    tmp.add(left);
                }
                Position bottom = getBottom(grid, pos);
                if (bottom != null) {
                    tmp.add(bottom);
                }
                Position right = getRight(grid, pos);
                if (right != null) {
                    tmp.add(right);
                }
            } while(!queue.isEmpty());
            queue = tmp;
            if (!queue.isEmpty()) {
                minute++;
            }
        }
        lastFindRotting(grid);
        return isFresh ? -1 : minute;
    }

    private void initFindRotting(int[][] grid, Queue<Position> queue) {
        m = grid.length;
        n = grid[0].length;
        for (int w = 0; w < m; w++) {
            for (int h = 0; h < n; h++) {
                if (grid[w][h] == 2) {
                    queue.add(new Position(w, h));
                }
                if (grid[w][h] == 1) {
                    isFresh = true;
                }
            }
        }
    }

    private void lastFindRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int w = 0; w < m; w++) {
            for (int h = 0; h < n; h++) {
                if (grid[w][h] == 1) {
                    isFresh = true;
                }
            }
        }
    }

    private Position getTop(int[][] grid, Position pos) {
        int x = pos.x;
        int y = pos.y;
        if (x <= 0) {
            return null;
        }
        if (grid[x-1][y] == 1) {
            grid[x-1][y] = 2;
            return new Position(x-1, y);
        }
        return null;
    }

    private Position getLeft(int[][] grid, Position pos) {
        int x = pos.x;
        int y = pos.y;
        if (y <= 0) {
            return null;
        }
        if (grid[x][y-1] == 1) {
            grid[x][y-1] = 2;
            return new Position(x, y-1);
        }
        return null;
    }

    private Position getRight(int[][] grid, Position pos) {
        int x = pos.x;
        int y = pos.y;
        if (y >= n - 1) {
            return null;
        }
        if (grid[x][y+1] == 1) {
            grid[x][y+1] = 2;
            return new Position(x, y + 1);
        }
        return null;
    }

    private Position getBottom(int[][] grid, Position pos) {
        int x = pos.x;
        int y = pos.y;
        if (x >= m - 1) {
            return null;
        }
        if (grid[x+1][y] == 1) {
            grid[x+1][y] = 2;
            return new Position(x + 1, y);
        }
        return null;
    }

    class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        // int[][] grid= {{2,1,1},{1,1,0}, {0,1,1}};
        int[][] grid= {{1, 2}};
        System.out.println(new Solution().orangesRotting(grid));
    }

}