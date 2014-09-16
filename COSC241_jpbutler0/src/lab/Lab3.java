/**
 *
 * @author Jackal
 */
package lab;

import collection.MySearch;
import collection.MyVector;
import collection.MySort;
import java.util.Random;
import java.util.Comparator;

public class Lab3 {

    public static void test() {

        Comparator<Integer> target = new Comparator<Integer>() {
            @Override

            public int compare(Integer x, Integer y) {
                return x.compareTo(y);
            }
        };
        MyVector numVec = new MyVector();
        MyVector numVec2 = new MyVector();
        MySort sort = new MySort();
        MySearch search = new MySearch();
        Random generator = new Random();
        int temp;
        for (int i = 0; i < 1000; i++) {
            temp = (generator.nextInt(899)) + 100;
            numVec.add(temp);
        }
        System.out.println("Random integer vector between [100,999]: ");
        System.out.println(numVec.toString());

        numVec2 = numVec.clone();
        System.out.println("'numVec' clone 'numVec2': ");
        System.out.println(numVec2.toString());

        sort.bubbleSort(numVec, target);
        System.out.println("Bubble-sorted numVec: ");
        System.out.println(numVec.toString());

        temp = search.linearSearch(numVec, 933, target);
        System.out.println("Location of '933' in numVec using linear search: "
                + temp);

        sort.selectionSort(numVec2, target);
        System.out.println("Selsection-sorted numVec2: ");
        System.out.println(numVec2.toString());

        temp = search.binarySearch(numVec2, 607, target);
        System.out.println("Location of '607' in numVec2 using binary search: "
                + temp);
    }
}
