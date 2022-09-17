import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        int len = keyName.length;
        Integer[] idxArr = new Integer[len];
        int[] secArr = new int[len];
        for (int i = 0; i < len; i++) {
            idxArr[i] = i;
            String[] timePair = keyTime[i].split(":");
            int hour = Integer.valueOf(timePair[0]);
            int min = Integer.valueOf(timePair[1]);
            secArr[i] = hour * 3600 + min * 60;
        }
        Arrays.sort(idxArr, (l, r) -> {
            if (keyName[l].equals(keyName[r])) {
                return secArr[l] - secArr[r];
            }
            return keyName[l].compareTo(keyName[r]);
        });
        
        List<String> ans = new ArrayList<>();
        int l = 0, r = 2;
        int lPos = 0, rPos = 0;
        while (l < len - 2) {
            lPos = idxArr[l];
            String lName = keyName[lPos];
            rPos = idxArr[r];
            String rName = keyName[rPos];
            if (lName.equals(rName) && secArr[rPos] - secArr[lPos] <= 3600) {
                ans.add(lName);
                l = l + 3;
                r = r + 3;
                while (l < len - 2 && lName.equals(keyName[idxArr[l]])) {
                    l++;
                    r++;
                }
                continue;
            }
            l++;
            r++;
        }
        return ans;
    }

}