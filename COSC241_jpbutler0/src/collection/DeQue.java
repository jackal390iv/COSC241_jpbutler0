package collection;

import java.util.NoSuchElementException;

public class DeQue {

    DLNode head;
    DLNode tail;

    public void insertFront(Object data) {
        if (head == null) {
            head = tail = new DLNode(data, null, null);
        } else {
            head.prev = new DLNode(data, head, null);
            head = head.prev;
        }
    }

    public void insertBack(Object data) {
        if (tail == null) {
            head = tail = new DLNode(data, null, null);
        } else {
            tail.next = new DLNode(data, null, tail);
            tail = tail.next;
        }
    }

    public Object removeFront() {
        if (head == null) {
            throw new NoSuchElementException();
        } else if (head == tail) {
            Object temp = head.data;
            head = tail = null;
            return temp;
        } else {
            Object temp = head.data;
            head = head.next;
            return temp;
        }
    }

    public Object removeBack() {
        if (tail == null) {
            throw new NoSuchElementException();
        } else if (head == tail) {
            Object temp = tail.data;
            head = tail = null;
            return temp;
        } else {
            Object temp = tail.data;
            tail = tail.prev;
            tail.next.prev = null;
            tail.next = null;
            return temp;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }
}
