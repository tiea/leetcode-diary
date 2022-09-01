import java.util.LinkedList;
import java.util.Deque;

class Solution {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int len = pushed.length;
        Deque<Integer> deque = new LinkedList<>();
        int pushPos = 0, popPos = 0;
        int needPop = 0;
        while (popPos < len) {
            needPop = popped[popPos];
            Integer cur = deque.peek();
            if (cur != null && cur == needPop) {
                deque.poll();
                popPos++;
                continue;
            }
            int pushCur = -1;
            while (pushPos < len) {
                pushCur = pushed[pushPos++];
                if (pushCur == needPop) {
                    popPos++;
                    break;
                }
                deque.offerFirst(pushCur);
            }
            if (needPop != pushCur) {
                return false;
            }
        }
        return true;
    }

}