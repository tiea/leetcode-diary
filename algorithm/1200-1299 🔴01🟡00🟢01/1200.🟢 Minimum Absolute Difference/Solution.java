import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> list = null;
        List<Integer> diffList = null;
        int minDiff = Integer.MAX_VALUE;
        int diff = 0;
        for (int i = 1; i < arr.length; i++) {
            int l = arr[i];
            int r = arr[i - 1];
            diff = l - r;
            if (minDiff < diff) {
                continue;
            }
            if (minDiff > diff) {
                list = new ArrayList<>();
                minDiff = diff;
            }
            if (minDiff == diff) {
                diffList = new ArrayList<>(2);
                diffList.add(r);
                diffList.add(l);
                list.add(diffList);
            }
        }
        return list;
    }

}