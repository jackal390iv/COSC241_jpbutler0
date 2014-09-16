/**
 *
 * @author Jackal
 */
package collection;

public class MySet<E> implements Cloneable {

    MyVector<E> a;

    /**
     * basic constructor creating a MyVector object
     */
    public MySet() {
        a = new MyVector<E>();
    }

    /**
     * a constructor that creates a MyVector object of size 'intialCapacity'
     *
     * @param initialCapacity
     */
    public MySet(int initialCapacity) {
        a = new MyVector<E>(initialCapacity);
    }

    /**
     * adds element to MySet, only if element does not already exist in MySet
     *
     * @param e
     * @return boolean true if element added to MySet
     */
    public boolean add(E e) {
        if (a.contains(e)) {
            return false;
        } else {
            return a.add(e);
        }
    }

    /**
     * adds all elements of MySet b to current MySet
     *
     * @param b
     * @return boolean true if elements added to MySet
     */
    public boolean addAll(MySet b) {
        for (int i = 0; i < b.size(); i++) {
            add((E) b.a.get(i));
        }
        return true;
    }

    /**
     * clears MySet of all elements
     */
    public void clear() {
        a.clear();
    }

    /**
     * clones MySet
     *
     * @return clone of MySet
     */
    public MySet clone() {
        try {
            MySet s = (MySet) super.clone();
            s.a = a.clone();
            return s;
        } catch (CloneNotSupportedException ex) {
            throw new InternalError();
        }
    }

    /**
     * searches for element in MySet
     *
     * @param element
     * @return boolean true if MySet contains element
     */
    public boolean contains(Object element) {
        return a.contains(element);
    }

    /**
     * checks if all elements in b exist in the current set
     *
     * @param b
     * @return boolean true if all elements in b are in current MySet
     */
    public boolean containsAll(MySet b) {
        boolean con = true;
        for (int i = 0; i < a.size(); i++) {
            if (!(b.contains(a.get(i)))) {
                con = false;
            }
        }
        return con;
    }

    /**
     * removes element from MySet
     *
     * @param element
     * @return boolean true if the element was removed
     */
    public boolean remove(Object element) {
        return a.remove(element);
    }

    /**
     * removes all elements that exist in b from the current set
     *
     * @param b
     * @return boolean true when all elements that exist in b are removed from
     * the current set
     */
    public boolean removeAll(MySet b) {
        int location;
        for (int i = 0; i < b.size(); i++) {
            if (a.contains(b.a.get(i))) {
                location = a.indexOf(b.a.get(i));
                a.remove(location);
            }
        }
        return true;
    }

    /**
     * removes all elements that are not in both b and the current set
     *
     * @param b
     * @return true when all elements that exist in the current set and not in b
     * and all elements that exist in b but not in the current set have been
     * removed
     */
    public boolean retainAll(MySet b) {
        MySet clony = this.clone();
        clony.removeAll(b);
        removeAll(clony);
        return true;
    }

    /**
     *
     * @return integer size of the MySet
     */
    public int size() {
        return a.size();
    }

    /**
     * removes all elements that are in both the current set and b
     *
     * @param b
     * @return boolean true when all elements that exist in both the current set
     * and b have been removed
     */
    public boolean symmetricDifference(MySet b) {
        MySet clones = this.clone();
        clones.retainAll(b);
        addAll(b);
        removeAll(clones);
        return true;
    }

    /**
     *
     * @return a String representation of the MySet
     */
    public String toString() {
        return a.toString();
    }
}
