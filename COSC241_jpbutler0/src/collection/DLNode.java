package collection;

public class DLNode {

    Object data;
    DLNode next;
    DLNode prev;

    public DLNode(Object data, DLNode next, DLNode prev) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

}
