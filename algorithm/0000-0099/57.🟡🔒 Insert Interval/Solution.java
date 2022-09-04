import java.util.ArrayList;

class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        if (len == 0) {
            return new int[][]{newInterval};
        }
        int[] arr = new int[(len + 1) * 2];
        int min = newInterval[0];
        int max = newInterval[1];
        int pos = 0;
        boolean isMatchEnd = false;
        for (int i = 0; i < len; i++) {
            int[] range = intervals[i];
            int cMin = range[0];
            int cMax = range[1];
            
        }
    }

}