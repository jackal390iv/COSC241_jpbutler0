package collection;

import java.util.EmptyStackException;

public class MyStack {

    SLListNode head;

    public MyStack() {
    }

    /**
     * adds an element onto the front of the stack, replacing 'head'
     *
     * @param data, object that will be added to the stack
     */
    public void push(Object data) {
        if (head == null) {
            head = new SLListNode(data, null);
        } else {
            head = new SLListNode(data, head);
        }
    }

    /**
     * removes the first element from the stack
     *
     * @return's object that has been removed from the stack
     */
    public Object pop() {
        if (head == null) {
            throw new EmptyStackException();
        } else {
            Object temp = head.data;
            head = head.next;
            return temp;
        }
    }

    /**
     * nondestructive look at the first element in the stack 'head'
     *
     * @return's object data from the first element in the stack; the 'head'
     */
    public Object peek() {
        if (head == null) {
            return null;
        } else {
            return head.data;
        }
    }

    /**
     * clears all elements in the stack
     */
    public void clear() {
        head = null;
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
