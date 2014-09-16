/**
 *
 * @author Jackal
 */
package collection;

import java.util.Comparator;

public class MySearch {

    public MySearch() {
    }

    /**
     * use binary search to find index of element 'key', bigO(logN)
     *
     * @param <T>, any element type
     * @param vector, import vector you are searching through
     * @param key, element you are searching for
     * @param target, import comparator 'target' to use in sort comparisons
     * @return location of element, or -1 if not found
     */
    public static <T> int binarySearch(MyVector vector, T key, Comparator target) {
        int low = 0, high = vector.size() - 1, mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if ((target.compare(vector.get(mid), key)) == 1) {
                high = mid - 1;
            } else if ((target.compare(vector.get(mid), key)) == -1) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * use linear search to find index of element 'key', bigO(N)
     *
     * @param <T>, any element type
     * @param vector, import vector you are searching through
     * @param key, element you are searching for
     * @param target, import comparator 'target' to use in sort comparisons
     * @return location of element, or -1 if not found
     */
    public static <T> int linearSearch(MyVector vector, T key, Comparator target) {
        int tempInt, n = vector.size();
        Object temp;
        for (int i = 0; i < n; i++) {
            tempInt = target.compare(vector.get(i), key);
            if (tempInt == 0) {
                return i;
            }
        }
        return -1;
    }
}
