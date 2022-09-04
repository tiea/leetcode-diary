import java.util.*;

class Solution {

    public int[] assignTasks(int[] servers, int[] tasks) {
        int tLen = tasks.length;
        Queue<Server> sQueue = new PriorityQueue<>(new Comparator<Server>() {
            @Override
            public int compare(Server l, Server r) {
                if (l.weight == r.weight) {
                    return l.pos - r.pos;
                }
                return l.weight - r.weight;
            }
        });
        Queue<Task> tQueue = new PriorityQueue<>(new Comparator<Task>() {
            @Override
            public int compare(Task l, Task r) {
                return l.pos - r.pos;
            }
        });
        SortedMap<Integer, List<Server>> endMap = new TreeMap<>();
        int sLen = servers.length;
        for (int i = 0; i < sLen; i++) {
            sQueue.add(new Server(servers[i], i));
        }
        int pos = 0, sec = 0;
        int[] ans = new int[tLen];
        while (pos < tLen || tQueue.size() > 0) {
            if (pos < tLen) {
                tQueue.add(new Task(tasks[pos], pos));
            }

            if (endMap.containsKey(sec)) {
                List<Server> sList = endMap.get(sec);
                for (Server s : sList) {
                    sQueue.add(s);
                }
                endMap.remove(sec);
            }
            if (sQueue.size() <= 0) {
                int minSec = endMap.firstKey();
                if (minSec > sec) {
                    for (int i = 1; i < minSec - sec && pos + i < tLen; i++) {
                        tQueue.add(new Task(tasks[pos + i], pos + i));
                    }
                }
                sec = minSec;
                pos = minSec;
                continue;
            }
            while (tQueue.size() > 0) {
                Server s = sQueue.poll();
                if (s == null) {
                    break;
                }
                if (s.pos == 378) {
                    System.out.println(378);
                }
                Task t = tQueue.poll();
                int endTime = sec + t.duration;
                List<Server> sList = endMap.get(endTime);
                if (sList == null) {
                    sList = new ArrayList<>();
                    endMap.put(endTime, sList);
                }
                sList.add(s);
                ans[t.pos] = s.pos;
            }
            sec++;
            pos++;
        }
        return ans;
    }
    
    class Server {
        int weight;
        int pos;

        public Server(int weight, int pos) {
            this.weight = weight;
            this.pos = pos;
        }
    }
    class Task {
        int duration;
        int pos;
        public Task(int duration, int pos) {
            this.duration = duration;
            this.pos = pos;
        }
    }
}