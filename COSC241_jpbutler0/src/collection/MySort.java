/**
 *
 * @author Jackal
 */
package collection;

import java.util.Comparator;
import java.util.Vector;

public class MySort {

    public MySort() {
    }

    /**
     * @param vector, vector that will be sorted by bubbleSort
     * @param target, import comparator 'target' to use in sort comparisons
     */
    public void bubbleSort(MyVector vector, Comparator target) {
        int tempInt;
        int n = vector.size();
        Object temp = null;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                tempInt = target.compare(vector.get(j - 1), vector.get(j));
                if (tempInt == 1) {
                    temp = vector.get(j - 1);
                    vector.set((j - 1), vector.get(j));
                    vector.set((j), temp);
                }
            }
        }
    }

    /**
     * @param vector, vector that will be sorted by selectionSort
     * @param target, import comparator 'target' to use in sort comparisons
     */
    public void selectionSort(MyVector vector, Comparator target) {
        int j;
        int tempInt;
        int n = vector.size();
        Object temp = null;
        for (int i = 0; i < n; i++) {
            j = i + 1;
            while (j < n) {
                tempInt = target.compare(vector.get(i), vector.get(j));
                if (tempInt == 1) {
                    temp = vector.get(i);
                    vector.set((i), vector.get(j));
                    vector.set((j), temp);
                }
                j++;
            }
        }
    }

    /**
     * @param vec, vector that will be sorted by quicksort
     * @param t, comparator that is used when comparing elements in vec
     */
    public static <T> void Quicksort(MyVector<T> vec, Comparator<T> t) {
        sort(vec, 0, vec.size() - 1, t);
    }

    private static <T> void sort(MyVector<T> a, int lo, int hi, Comparator<T> t) {
        if (hi <= lo) {
            return;
        }
        int j = partotion(a, lo, hi, t);
        sort(a, lo, j - 1, t);
        sort(a, j + 1, hi, t);
    }

    private static <T> int partotion(MyVector<T> a, int lo, int hi, Comparator t) {
        int i = lo;
        int j = hi + 1;
        T v = a.get(lo);
        while (true) {

            while (t.compare(a.get(++i), v) < 0) {
                if (i == hi) {
                    break;
                }
            }

            while (t.compare(v, a.get(--j)) < 0) {
                if (j == lo) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }

            a.swap(a, i, j);
        }
        a.swap(a, lo, j);
        return j;
    }

    /**
     * @param vec, vector that will be sorted by shellSort
     */
    public static void ShellSort(MyVector vec) {
        int inner, outer;
        Object target;
        int h = 1;
        while (h <= vec.size() / 3) {
            h = 3 * h + 1;
        }
        while (h > 0) {
            for (outer = h; outer < vec.size(); outer++) {
                target = vec.get(outer);
                inner = outer;
                while ((inner > h - 1) && ((Comparable) vec.get(inner - h)).compareTo(target) > 0) {
                    vec.set(inner, vec.get(inner - h));
                    inner -= h;
                }
                vec.set(inner, target);
            }
            h = (h - 1) / 3;
        }
    }

    /**
     * @param vec, vector that will be sorted by insertionSort
     * @param left, input 0 //for first element
     * @param right, input vec.size()-1 //for last element
     */
    public static void insertionSort(MyVector vec, int left, int right) {
        int inner, outer;
        Object target;
        for (outer = left + 1; outer <= right; outer++) {
            target = vec.get(outer);
            inner = outer;
            while ((inner > left) && ((Comparable) vec.get(inner - 1)).compareTo(target) > 0) {
                vec.set(inner, vec.get(inner - 1));
                inner--;
            }
            vec.set(inner, target);
        }
    }

    private static void mergeArrays(MyVector vec, int startL, int stopL, int startR, int stopR) {
        int[] right = new int[stopR - startR + 1];
        int[] left = new int[stopL - startL + 1];
        for (int i = 0, k = startR; i < (right.length - 1); ++i, ++k) {
            right[i] = (int) vec.get(k);
        }
        for (int i = 0, k = startL; i < (left.length - 1); ++i, ++k) {
            left[i] = (int) vec.get(k);
        }
        right[right.length - 1] = Integer.MAX_VALUE;
        left[left.length - 1] = Integer.MAX_VALUE;
        for (int k = startL, m = 0, n = 0; k < stopR; ++k) {
            if (left[m] <= right[n]) {
                vec.set(k, left[m]);
                m++;
            } else {
                vec.set(k, right[n]);
                n++;
            }
        }
    }

    /**
     * @param vec, vector that will be sorted by shellSort
     */
    public static void mergeSort(MyVector vec) {
        if (vec.size() < 2) {
            return;
        }
        int step = 1;
        int left, right;
        while (step < vec.size()) {
            left = 0;
            right = step;
            while ((right + step) <= (vec.size())) {
                mergeArrays(vec, left, left + step, right, right + step);
                left = right + step;
                right = left + step;
            }
            if (right < vec.size()) {
                mergeArrays(vec, left, left + step, right, vec.size());
            }
            step *= 2;
        }
    }
}
