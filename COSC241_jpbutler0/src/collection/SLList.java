package collection;

public class SLList {

    SLListNode head;

    /**
     * clears the entire linked list
     */
    public void clear() {
        head = null;
    }

    /**
     * @return true if linked list is empty, false if it is not
     */
    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }

    /**
     * inserts new node of object element into linked list
     *
     * @param element, inserts element into linked list
     */
    public void insert(Object element) {
        head = new SLListNode(element, head);
    }

    /**
     * @param element, object that will be removed from the list
     */
    public Object remove(Object element) {
        SLListNode ref = head;
        SLListNode val = null;
        if (head.data == element) {
            head = head.next;
            return ref;
        }
        while ((ref.next != null) && !(ref.next.data.equals(element))) {
            ref = ref.next;
        }
        if (ref.next == null) {
            return null;
        }
        val = ref;
        ref.next = ref.next.next;
        return val;
    }

    /**
     * returns a sting representation of the linked list
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        SLListNode ref = head;
        while (ref.next != null) {
            str.append(ref.data + ",");
            ref = ref.next;
        }
        String string = str.toString();
        return string;
    }
}
