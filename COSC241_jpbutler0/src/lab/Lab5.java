package lab;

import java.util.Comparator;
import java.util.Random;
import collection.MySort;
import collection.MyVector;

public class Lab5 {

    public static void test() {
        Comparator<Integer> target = new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                return x.compareTo(y);
            }
        };

        Random generator = new Random();
        MySort sort = new MySort();
        MyVector vec = new MyVector();
        int temp = 0;
        int val = 20000 - 1;
        long start, stop;
        generator.setSeed(123456);
        for (int i = 0; i < 20000; i++) {
            temp = (generator.nextInt(99999));
            vec.add(temp);
        }

        start = (System.currentTimeMillis());
        sort.mergeSort(vec);
        stop = (System.currentTimeMillis());
        System.out.println("mergeSort completed in: " + (stop - start) + "\n");

        vec.clear();
        for (int i = 0; i < 20000; i++) {
            temp = (generator.nextInt(99999));
            vec.add(temp);
        }

        start = (System.currentTimeMillis());
        sort.bubbleSort(vec, target);
        stop = (System.currentTimeMillis());
        System.out.println("bubbleSort completed in: " + (stop - start) + "\n");

        vec.clear();
        for (int i = 0; i < 20000; i++) {
            temp = (generator.nextInt(99999));
            vec.add(temp);
        }

        start = (System.currentTimeMillis());
        sort.ShellSort(vec);
        stop = (System.currentTimeMillis());
        System.out.println("shellSort completed in: " + (stop - start) + "\n");

        vec.clear();
        for (int i = 0; i < 20000; i++) {
            temp = (generator.nextInt(99999));
            vec.add(temp);
        }

        start = (System.currentTimeMillis());
        sort.selectionSort(vec, target);
        stop = (System.currentTimeMillis());
        System.out.println("selectionSort completed in: " + (stop - start) + "\n");

        vec.clear();
        for (int i = 0; i < 20000; i++) {
            temp = (generator.nextInt(99999));
            vec.add(temp);
        }

        start = (System.currentTimeMillis());
        sort.insertionSort(vec, 0, val);
        stop = (System.currentTimeMillis());
        System.out.println("insertionSort completed in: " + (stop - start) + "\n");

        vec.clear();
        for (int i = 0; i < 20000; i++) {
            temp = (generator.nextInt(99999));
            vec.add(temp);
        }

        start = (System.currentTimeMillis());
        sort.Quicksort(vec, target);
        stop = (System.currentTimeMillis());
        System.out.println("quickSort completed in: " + (stop - start) + "\n");
    }
}
