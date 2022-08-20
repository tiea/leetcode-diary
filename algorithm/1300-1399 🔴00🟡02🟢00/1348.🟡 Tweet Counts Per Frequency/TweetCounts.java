import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

class TweetCounts {

    Map<String, SortedMap<Integer, Integer>> tweetNameMap;

    public TweetCounts() {
        tweetNameMap = new HashMap<>();
    }
    
    public void recordTweet(String tweetName, int time) {
        SortedMap<Integer, Integer> countMap = tweetNameMap.get(tweetName);
        if (countMap == null) {
            countMap = new TreeMap<>();
            tweetNameMap.put(tweetName, countMap);
        }
        Integer count = countMap.get(time);
        if (count == null) {
            count = 0;
        }
        count++;
        countMap.put(time, count);
    }
    
    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        SortedMap<Integer, Integer> countMap = tweetNameMap.get(tweetName).subMap(startTime, endTime + 1);
        int step = 60;
        if (freq.equals("hour")) {
            step = 3600;
        } else if (freq.equals("day")) {
            step = 86400;
        }
        List<Integer> result = new ArrayList<>();
        int start = startTime;
        int end = startTime + step;

        Iterator<Integer> iterator = countMap.keySet().iterator();
        int count = 0;
        while(iterator.hasNext()) {
            Integer time = iterator.next();
            while (time >= end) {
                start = end;
                end = start + step;
                end = end > endTime + 1 ? endTime + 1 : end;
                result.add(count);
                count = 0;
            }
            count += countMap.get(time);
        }
        result.add(count);
        count = 0;
        while (endTime >= end) {
            start = end;
            end = start + step;
            end = end > endTime + 1 ? endTime + 1 : end;
            result.add(count);
        }
        return result;
    }

}

/**
 * Your TweetCounts object will be instantiated and called as such:
 * TweetCounts obj = new TweetCounts();
 * obj.recordTweet(tweetName,time);
 * List<Integer> param_2 = obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
 */