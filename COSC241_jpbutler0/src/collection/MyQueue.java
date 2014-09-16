package collection;

import java.util.NoSuchElementException;

public class MyQueue {

    public MyQueue() {
    }
    SLListNode head;
    SLListNode tail;

    /**
     * adds object to the front of the queue
     *
     * @param data, object that will be added to the front of the queue
     */
    public void insertFront(Object data) {
        if (head == null) {
            tail = head = new SLListNode(data, null);
        } else {
            head = new SLListNode(data, head);
        }
    }

    /**
     * adds object to the back of the queue
     *
     * @param data, object that will be added to the back of the queue
     */
    public void insertBack(Object data) {
        if (head == null) {
            tail = head = new SLListNode(data, null);
        } else {
            tail = tail.next = new SLListNode(data, null);
        }
    }

    /**
     * returns first element in the queue
     *
     * @return's object data from the first element in the queue; the 'head'
     */
    public Object getFront() {
        if (head == null) {
            return null;
        } else {
            return head.data;
        }
    }

    /**
     * returns last element in the queue
     *
     * @return's object data from the last element in the queue; the 'tail'
     */
    public Object getBack() {
        if (tail == null) {
            return null;
        } else {
            return tail.data;
        }
    }

    /**
     * removes the first element in the queue
     *
     * @return's object removed from the front of the queue; previously the
     * first element in the queue
     */
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

    /**
     * removes the last element in the queue
     *
     * @return's object removed from the back of the queue; previously the last
     * element in the queue
     */
    public Object removeBack() {
        if (tail == null) {
            throw new NoSuchElementException();
        } else if (head == tail) {
            Object temp = tail.data;
            head = tail = null;
            return temp;
        } else {
            Object temp = tail.data;
            SLListNode ref = head;
            while (ref.next.next != null) {
                ref = ref.next;
            }
            tail = ref;
            tail.next = null;
            return temp;
        }
    }

    /**
     * clears the queue of all elements
     */
    public void clear() {
        head = tail = null;
    }

    /**
     * checks to see if the stack is empty
     *
     * @return true if the stack is empty, false if it is not
     */
    public boolean isEmpty() {
        return head == null;
    }
}
