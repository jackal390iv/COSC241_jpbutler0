package lab;

import collection.SLList;
import collection.SortedSSList;

public class Lab6 {

    public static void test() {

        SLList simpleList = new SLList();
        for (int i = 0; i < 31; i++) {
            simpleList.insert(i * i);
        }
        System.out.println("A Link List 'simpleList' containing the first 30 perfect square numbers: ");
        System.out.println(simpleList.toString() + "\n");
        simpleList.remove(36);
        simpleList.remove(64);
        simpleList.remove(100);
        simpleList.remove(400);
        System.out.println("simpleList with 36,64,144, and 400 removed: ");
        System.out.println(simpleList.toString() + "\n");

        SortedSSList sortedList = new SortedSSList();
        for (int i = 1; i < 32; i++) {
            sortedList.insert(i * i);
        }

        System.out.println("'sortedList' containing the first 31 perfect square numbers: ");
        System.out.println(sortedList.toString() + "\n");
        sortedList.remove(1);
        sortedList.remove(36);
        sortedList.remove(64);
        sortedList.remove(144);
        sortedList.remove(400);
        sortedList.remove(900);
        System.out.println("sortedList with 1,36,64,144,400, and 900 removed: ");
        System.out.println(sortedList.toString() + "\n");

        sortedList.insert(1);
        sortedList.insert(64);
        sortedList.insert(400);
        sortedList.insert(900);
        System.out.println("sortedList with 1,64,400, and 900 added back in: ");
        System.out.println(sortedList.toString() + "\n");
    }
}
