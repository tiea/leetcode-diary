import java.util.Arrays;

class Solution {

    public double trimMean(int[] arr) {
        int len = arr.length;
        Arrays.sort(arr);
        int start = len * 5 / 100;
        int end = len - start - 1;
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += arr[i];
        }
        return sum * 1.0 / (end - start + 1);
    }

}