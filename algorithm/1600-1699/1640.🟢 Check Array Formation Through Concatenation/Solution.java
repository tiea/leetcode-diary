class Solution {

    public boolean canFormArray(int[] arr, int[][] pieces) {
        int len = arr.length;
        int[] idx = new int[101];
        int pLen = pieces.length;
        for (int i = 0; i < pLen; i++) {
            idx[pieces[i][0]] = i + 1;
        }
        int i = 0;
        while (i < len) {
            int cur = arr[i];
            int pos = idx[cur];
            if (pos == 0) {
                return false;
            }
            int[] sub = pieces[pos - 1];
            for (int j = 0; j < sub.length; j++) {
                if (sub[j] != arr[i]) {
                    return false;
                }
                i++;
            }
        }
        return true;
    }

}