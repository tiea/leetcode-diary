import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int length = arr.length;
        if (x <= arr[0]) {
            return copy(arr, 0, k);
        }
        if (x >= arr[length - 1]) {
            return copy(arr, length - k, length);
        }
        int start = 0, end = length - 1;
        int pos = 0;
        int l = 0, r = 0;
        while (true) {
            pos = start + (end - start) / 2;
            l = arr[pos];
            r = arr[pos + 1];
            if (x > l && x < r) {
                pos = (x - l <= r - x) ? pos : pos + 1;
                break;
            } else if (x >= l && x < r) {
                break;
            } else if (x > l && x <= r) {
                pos = pos + 1;
                break;
            }
            if (l < x) {
                start = pos;
            } else {
                end = pos;
            }
        }
        start = pos;
        end = pos;
        while (end - start < k - 1) {
            if (start == 0) {
                end++;
                continue;
            }
            if (end == length - 1) {
                start--;
                continue;
            }
            int s = arr[start - 1];
            int e = arr[end + 1];
            if (x - s <= e - x) {
                start--;
            } else {
                end++;
            }
        }
        return copy(arr, start, end + 1); 
    }

    public List<Integer> copy(int[] arr, int from, int to) {
        List<Integer> list = new ArrayList<>(to - from);
        for (int i = 0; i < to - from; i++) {
            list.add(arr[from + i]);
        }
        return list;
    }
    public static void main(String[] args) {
        new Solution().findClosestElements(new int[]{0,1,1,1,2,3,6,7,8,9}, 9, 4);
    }

}