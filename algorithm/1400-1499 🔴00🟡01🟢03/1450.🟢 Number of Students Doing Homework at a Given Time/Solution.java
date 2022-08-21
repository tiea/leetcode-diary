class Solution {

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int ptr = 0, length = startTime.length, count = 0;
        while (ptr < length) {
            if (startTime[ptr++] > queryTime || endTime[ptr - 1] < queryTime) {
                continue;
            }
            count++;
        }
        return count;
    }

}