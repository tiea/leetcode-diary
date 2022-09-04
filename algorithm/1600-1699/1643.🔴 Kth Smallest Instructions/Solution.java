class Solution {

    int length, pos;

    public String kthSmallestPath(int[] destination, int k) {
        pos = k;
        int row = destination[0];
        int col = destination[1];
        int colIndex = 0;
        long count = 1;
        for (int i = 0; i < col; i++) {
            count *= (row + i + 1);
            if (count % (col - colIndex) == 0) {
                count = count / (col - colIndex++);
            }
        }
        while (colIndex < col) {
            count = count / (col - colIndex++);
        }
        // 总路径数量
        length = Integer.parseInt(count + "");
        return nextStep(row, col);
    }
    // next
    private String nextStep(int row, int col) {
        // end
        if (row <= 0 && col <= 0) {
            return "";
        }
        // olny H or V
        if (row <= 0) {
            return "H" + nextStep(row, col - 1);
        } else if (col <= 0) {
            return "V" + nextStep(row - 1, col);
        }
        // 找到 H、V 的分割位置
        int splitPos = 0;
        if (length % (row + col) == 0) {
            // 防止溢出
            splitPos = length / (row + col) * col;
        } else {
            // 防止出现小数，（测试用例里面溢出和小数好像不会同时出现）
            splitPos = (length * col) / (row + col);
        }
        // 位置在分割为之前
        if (pos <= splitPos) {
            length = splitPos;
            return "H" + nextStep(row, col - 1);
        } else {
            length = length - splitPos;
            pos = pos - splitPos;
            return "V" + nextStep(row - 1, col);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().kthSmallestPath(new int[]{15 ,15}, 1));
        // System.out.println(new Solution().kthSmallestPath(new int[]{2 ,3}, 2));
    }

}