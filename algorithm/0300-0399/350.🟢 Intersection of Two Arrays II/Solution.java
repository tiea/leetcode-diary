import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

class Solution {


    public int[] intersect(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;

        List<Integer> result = new ArrayList<>();
        int[] minArray = length1 > length2 ? nums2 : nums1;
        int minLength = minArray.length;
        int[] maxArray = length1 > length2 ? nums1 : nums2;
        int maxLength = maxArray.length;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < minLength; i++) {
            int num = minArray[i];
            Integer count = countMap.get(num);
            if (count == null) {
                count = 0;
            }
            countMap.put(num, ++count);
        }
        int ptr = 0;
        while (ptr < maxLength && countMap.size() > 0) {
            int num = maxArray[ptr++];
            if (countMap.containsKey(num)) {
                result.add(num);
                int count = countMap.get(num);
                count--;
                if (count == 0) {
                    countMap.remove(num);
                    continue;
                }
                countMap.put(num, count);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }


    // 排序
    public int[] intersectBySort(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] result = new int[length1 > length2 ? length2 : length1];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int ptr1 = 0, ptr2 = 0;
        int i = 0;
        while (ptr1 < length1 && ptr2 < length2) {
            int num1 = nums1[ptr1];
            int num2 = nums2[ptr2];
            if (num1 == num2) {
                result[i++] = num1;
                ptr1++;
                ptr2++;
            } else if (num1 > num2) {
                ptr2++;
            } else {
                ptr1++;
            }
        }
        return Arrays.copyOfRange(result, 0, i);
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,9,8,4};
        new Solution().intersect(nums1, nums2);
    }

}