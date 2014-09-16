/**
 *
 * @author Jackal
 */
package collection;

import java.util.Arrays;

public class MyVector<E> implements Cloneable {

    Object[] elementData;
    int elementCount = 0;

    /**
     * creates an array of size 10
     *
     * @param no parameters needed
     * @return creates an array of size 10
     */
    public MyVector() {
        elementData = new Object[10];
    }

    /**
     * swaps two elements in the vector
     *
     * @param a vector that will be used
     * @param i location of first element to be swapped
     * @param j location of second element to be swapped
     */
    public static <T> void swap(MyVector<T> a, int i, int j) {
        a.set(i, a.set(j, a.get(i)));
    }

    /**
     * creates an array of size 'intialCapacity'
     *
     * @param sets initialCapacity as the new size of the array
     * @return null
     */
    public MyVector(int initialCapacity) {
        elementData = new Object[initialCapacity];
    }

    /**
     * checks the array size (ensureCapacity) to determine if there is room to
     * add an element, if there is, then the element is added to the end of the
     * array
     *
     * @param ensures that the array can have another element added without
     * overloading it, and then it adds element to the array
     * @return true if element added
     */
    public boolean add(E element) {
        ensureCapacity(elementCount + 1);
        elementData[elementCount] = element;
        elementCount++;
        return true;
    }

    /**
     * checks the array size (ensureCapacity) to determine if there is room to
     * add an element, if there is, then the element is added to the specified
     * location in the array and all there elements are moves right one space to
     * make room for it
     *
     * @param checks the array size (ensureCapacity) to determine if there is
     * room to add an element, if it can then it adds the element at index and
     * moves everything else over
     * @return null
     */
    public void add(int index, E element) {
        ensureCapacity(elementCount + 1);
        System.arraycopy(elementData, index, elementData, index + 1, elementCount - index);
        elementCount++;
        elementData[index] = element;
    }

    /**
     * checks the array size (ensureCapacity) to determine if there is room to
     * move the objects, if there is, then the objects are added to the end of
     * the array
     *
     * @param takes the size of the vector2 and ensures the capacity of the
     * array plus vector2, then adds vector2 to the array
     * @return returns true if the elements have been added
     */
    public boolean addAll(MyVector vector2) {
        ensureCapacity(elementCount + vector2.size());
        System.arraycopy(vector2.elementData, 0, elementData, elementCount, vector2.size());
        elementCount += vector2.size();
        return vector2.size() != 0;
    }

    /**
     * clears the array by setting the elementCount to 0, and setting the
     * element in 0 to null, leaving every element after 0 to be
     * ignored/overridden by future operations
     *
     * @param no parameter needed, clears all elements
     * @return null
     */
    public void clear() {
        for (int i = 0; i < elementCount; i++) {
            elementData[i] = null;
        }
        elementCount = 0;
    }

    /**
     * searches the array for the specified element, if it is found it returns
     * 'true' otherwise it returns 'false'
     *
     * @param element is the object being searched for
     * @return true if array contains element
     */
    public boolean contains(Object element) {

        for (int i = 0; i < elementCount; i++) {
            if (elementData[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * retrieves the element at 'index'
     *
     * @param index is the location being called
     * @return element at index
     */
    public E get(int index) {
        return (E) elementData[index];
    }

    /**
     * searches for the element, if the element is found it returns the index
     * location of the element, if not '-1' is returned
     *
     * @param element is the object being searched for
     * @return index of element if found, if not returns '-1'
     */
    public int indexOf(Object element) {
        for (int i = 0; i < elementCount; i++) {
            if (elementData[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * searches the array for specified element, if it is found it is removed
     * and 'true' is returned otherwise 'false' is returned
     *
     * @param element is The object to be removed.
     * @return if the removal was successful.
     */
    public boolean remove(Object element) {
        for (int i = 0; i < elementCount; i++) {
            if (elementData[i].equals(element)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * checks to see if the array is empty, to elaborate is elementCount = 0,
     * and there is no element in the that position, then it returns true
     *
     * @param takes no parameters
     * @return true if element is removed
     */
    public boolean isEmpty() {
        if (elementCount == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * creates a temp copy of the element at 'index', removes the element at
     * index, returns temp
     *
     * @param copys element at index into temp, and then removes element
     * @return returns temp
     */
    public E remove(int index) {
        E temp = (E) elementData[index];
        System.arraycopy(elementData, index + 1, elementData, index, elementCount - index - 1);
        elementCount--;
        return temp;
    }

    /**
     * creates a variable to hold the valve of the object to be overridden,
     * overwrites that object, and returns the variable
     *
     * @param copys the element at 'index' of the array, and then replaces that
     * element with element
     * @return returns the original element
     */
    public E set(int index, E element) {
        E temp = (E) elementData[index];
        elementData[index] = element;
        return temp;
    }

    /**
     * returns the arrays size by returning elementCount (total number of
     * elements in the array)
     *
     * @param no parameter needed
     * @return returns the size of the array
     */
    public int size() {
        return elementCount;
    }

    /**
     * checks the array to see if there is room to add an element
     *
     * @param checks if 'minCapacity can be added to the array without
     * overloading it
     * @return null
     */
    private void ensureCapacity(int minCapacity) {
        if (minCapacity - elementData.length > 0) {
            elementData = Arrays.copyOf(elementData, minCapacity);
        }
    }

    /**
     * creates a clone of the array by calling 'super.clone'
     *
     * @param no parameters needed
     * @return a clone of the array
     */
    public MyVector clone() {
        MyVector<E> v;
        try {
            v = (MyVector<E>) super.clone();
            v.elementData = Arrays.copyOf(elementData, elementCount);
            return v;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }

    }

    /**
     * prints out all elements of the array separated by ', '
     *
     * @param no parameter needed
     * @return a string of the array
     */
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("[").append(elementData[0]);
        for (int i = 1; i < elementCount; i++) {
            b.append(", ").append(elementData[i]);
        }
        b.append("]");
        return b.toString();
    }

    /**
     * reverses the elements of the vector by switching the last element with
     * the first, then the second element with the second-to-last element
     *
     * @param no parameters needed
     * @return array elements in reverse order
     */
    public MyVector reverse() {
        int i = 0, x = elementCount - 1;
        Object temp = null;
        for (int t = 0; t < (elementCount / 2); i++, x--, t++) {
            temp = elementData[i];
            elementData[i] = elementData[x];
            elementData[x] = temp;
        }
        return this;
    }
}
