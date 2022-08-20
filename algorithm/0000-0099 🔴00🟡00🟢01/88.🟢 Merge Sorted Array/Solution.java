class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ptr = m + n;
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        if (n == 0) {
            return;
        }
        int mNum = nums1[--m], nNum = nums2[--n];
        while (m >= 0 || n >= 0) {
            if (mNum >= nNum) {
                nums1[--ptr] = mNum;
                mNum = (--m) == -1 ? Integer.MIN_VALUE : nums1[m];

                continue;
            }
            if (mNum < nNum) {
                nums1[--ptr] = nNum;
                nNum = (--n) == -1 ? Integer.MIN_VALUE : nums2[n];
            }
        }
    }


    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 0, 0, 0 };
        int m = 3;
        int[] nums2 = { 2, 5, 6 };
        int n = 3;
        new Solution().merge(nums1, m, nums2, n);
    }
    
}