import java.util.SortedMap;
import java.util.TreeMap;

class Solution {

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int len = quality.length;
        SortedMap<Double, Integer> map = new TreeMap<>((l , r) -> r - l);
        for (int i = 0; i < len; i++) {
            map.put(quality[i] / wage[i], i);
        }
        
    }

}