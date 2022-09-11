import java.util.HashMap;

class Solution {


    public int maxPoints(int[][] points) {
        int len = points.length;
        Map<String, Set<Integer>> countMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int[] x = points[i];
            int[] y = null;
            for (int j = i + 1; j < len; j++) {
                y = points[j];
            }
        }
    }


}