package collection;

public class SLListNode {

    SLListNode next;
    Object data;

    /**
     * @param element, input element that will be held in the node
     * @param next, pointer to the next node in the link list
     */
    public SLListNode(Object element, SLListNode next) {
        this.data = element;
        this.next = next;
    }
}
