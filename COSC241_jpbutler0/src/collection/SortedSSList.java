package collection;

public class SortedSSList extends SLList {

    /**
     * creates a sorted linked list
     */
    @Override
    public void insert(Object element) {
        SLListNode ref = head;
        if (head == null) {
            head = new SLListNode(element, null);
            return;
        }
        if (((Comparable) head.data).compareTo((Comparable) element) > 0) {
            ref = null;
            ref = new SLListNode(element, head);
            head = ref;
            return;
        }

        while ((ref.next != null) && ((Comparable) ref.next.data).compareTo((Comparable) element) < 0) {
            ref = ref.next;
        }
        ref.next = new SLListNode(element, ref.next);
    }
}
