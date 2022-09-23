class MyLinkedList {

    Node head;

    Node tail;

    int size;

    public MyLinkedList() {

    }
    
    public int get(int index) {
        if (index >= size || index < 0) {
            return -1;
        }
        int pos = 0;
        Node cur = head;
        while (true) {
            if (pos == index) {
                return cur.num;
            }
            pos++;
            cur = cur.next;
        }
    }
    
    public void addAtHead(int val) {
        Node cur = null;
        if (size == 0) {
            cur = new Node(val);
            tail = cur;
        } else {
            cur = new Node(val, head, null);
            head.pre = cur;
        }
        head = cur;
        size++;
    }
    
    public void addAtTail(int val) {
        Node cur = null;
        if (size == 0) {
            cur = new Node(val);
            head = cur;
        } else {
            cur = new Node(val, null, tail);
            tail.next = cur;
        }
        tail = cur;
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index <= 0) {
            addAtHead(val);
            return;
        }
        if (index > size) {
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }
        int pos = 0;
        Node cur = head;
        while (true) {
            if (pos == index) {
                Node newNode = new Node(val, cur, cur.pre);
                cur.pre.next = newNode;
                cur.pre = newNode;
                size++;
                return;
            }
            pos++;
            cur = cur.next;
        }
    }
    
    public void deleteAtIndex(int index) {
        if (index >= size || index < 0) {
            return;
        }
        if (size == 1) {
            head = null;
            tail = null;
            size--;
            return;
        }
        if (index == 0) {
            head = head.next;
            head.pre = null;
            size--;
            return;
        }
        if (index == size - 1) {
            tail = tail.pre;
            tail.next = null;
            size--;
            return;
        }
        int pos = 0;
        Node cur = head;
        while (true) {
            if (pos == index) {
                cur.next.pre = cur.pre;
                cur.pre.next = cur.next;
                cur.next = null;
                cur.next = null;
                size--;
                return;
            }
            pos++;
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(7);
        list.addAtHead(2);
        list.addAtHead(1);
        list.addAtIndex(4, 0);
        list.deleteAtIndex(2);
    }

    class Node {

        public Node(int val) {
            num = val;
        }

        public Node(int val, Node n, Node p) {
            num = val;
            next = n;
            pre = p;
        }

        int num;

        Node next;

        Node pre;

    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */