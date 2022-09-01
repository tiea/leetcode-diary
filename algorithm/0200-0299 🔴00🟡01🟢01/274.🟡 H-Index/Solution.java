import java.util.Arrays;

class Solution {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);;
        int len = citations.length;
        if (citations[len - 1] == 0) {
            return 0 ;
        }
        int count = 0, cur = 0;
        for (int i = len - 1; i >= 0; i--) {
            cur = citations[i];
            if (cur < len - i) {
                count = len - i - 1;
                break;
            } else if (cur == len - i) {
                count = len - i;
                break;
            }
        }
        return count == 0 ? len : count;
    }

}