import java.util.Objects;

class MyCircularDeque {

    Node fNode, lNode;
    int size, maxSize;

    public MyCircularDeque(int k) {
        maxSize = k;
    }
    
    public boolean insertFront(int value) {
        if (size == maxSize) {
            return false;
        }
        Node node = new Node(value);
        if (size++ == 0) {
            lNode = node;
        }
        if (Objects.nonNull(fNode)) {
            node.next = fNode;
            fNode.pre = node;
        }
        fNode = node;
        return true;
    }
    
    public boolean insertLast(int value) {
        if (size == maxSize) {
            return false;
        }
        Node node = new Node(value);
        if (size++ == 0) {
            fNode = node;
        }
        if (Objects.nonNull(lNode)) {
            node.pre = lNode;
            lNode.next = node;
        }
        lNode = node;
        return true;
    }
    
    public boolean deleteFront() {
        if (size == 0) {
            return false;
        }
        size--;
        fNode = fNode.next;
        return true;
    }
    
    public boolean deleteLast() {
        if (size == 0) {
            return false;
        }
        size--;
        lNode = lNode.pre;
        return true;
    }
    
    public int getFront() {
        if (size == 0) {
            return -1;
        }
        return fNode.content;
    }
    
    public int getRear() {
        if (size == 0) {
            return -1;
        }
        return lNode.content;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == maxSize;
    }

    class Node {
        public Node (int content) {
            this.content = content;
        }
        int content;
        Node next, pre;
    }

}