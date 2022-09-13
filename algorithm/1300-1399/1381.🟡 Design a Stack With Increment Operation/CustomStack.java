class CustomStack {

    Node head;
    Node tail;
    int max;
    int size;

    public CustomStack(int maxSize) {
        max = maxSize;
        size = 0;
    }
    
    public void push(int x) {
        Node node = new Node(x);
        if (size == 0) {
            head = node;
            tail = node;
            size++;
            return;
        }
        if (size == max) {
            return;
        }
        head.pre = node;
        node.next = head;
        head = node;
        size++;
    }
    
    public int pop() {
        if (size == 0) {
            return -1;
        }
        size--;
        int val = head.val;
        if (size == 0) {
            head = null;
            tail = null;
            return val;
        }
        head = head.next;
        head.pre = null;
        return val;
    }
    
    public void increment(int k, int val) {
        Node pos = tail;
        while(k > 0 && pos != null) {
            k--;
            pos.val += val;
            pos = pos.pre;
        }
    }
    
    class Node {
        int val;
        Node next;
        Node pre;
        public Node(int val) {
            this.val = val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */