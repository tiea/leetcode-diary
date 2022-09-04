class Solution {

    int length;
    public int atMostNGivenDigitSet(String[] digits, int n) {
        length = digits.length;
        int ans = 0, length = digits.length, mod = 0;
        int[] digitArr = new int[length];
        for (int i = 0; i < length; i++) {
            digitArr[i] = Integer.valueOf(digits[i]);
        }
        if (n < 10) {
            return binarySearch(digitArr, n);
        }
        int pos = 1;
        int preSum = 1;
        while (n > 1) {
            mod = n % 10;
            n = n / 10;
            int bsPos = -1;
            if (mod != 0) {
                bsPos = binarySearch(digitArr, mod);
                if (bsPos > 0) {
                    ans += (preSum * bsPos);
                }
                if (n < 10) {
                    break;
                }
            }
            int ptr = 1;
            int sum = length;
            while (ptr < pos) {
                sum = sum * length;
                ptr++;
            }
            preSum = sum;
            ans += sum;
            pos++;
        }
        return ans;
    }

    public int numberCount(int n, int pos, int[] arr) {
        if (n < 10) {
            return 0;
        }
        int sum = 0;
        int mod = n % 10;
        if (pos == 1) {
            return numberCount(n / 10, ++pos, arr);
        }
        int modPos = binarySearch(arr, mod);
        sum = Double.valueOf(Math.pow(length, pos)).intValue();
        while () {

        }
        return sum + numberCount(n / 10, ++pos, arr);
    }

    public int binarySearch(int[] arr, int hkey) {
        int ans = -1;
        int start = 0, end = arr.length - 1;
        if (hkey < arr[start]) {
            return 0;
        }
        if (hkey > arr[end]) {
            return arr.length;
        }
        while (start <= end){
            int mid = start + (end - start) / 2;
            if (arr[mid] > hkey)
                end = mid - 1;
            else if (arr[mid] < hkey)
                start = mid + 1;
            else {
                ans = mid ;  
                break;
            }
        }
        if (ans == -1) {
            ans = start;
        }
        return ans;
    }

    public static void main(String[] args) {
        new Solution().atMostNGivenDigitSet(new String[] { "5","7" }, 19);
    }

}