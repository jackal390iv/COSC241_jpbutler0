/**
 *
 * @author Jackal
 */
package lab;

import collection.MyVector;

public class Lab2 {

    public Lab2() {
    }

    public static void test() {

        Object[] vector2;

        //creates a MyVector array of size 30
        MyVector<Integer> v = new MyVector<Integer>(30);

        //adds fibonacci numbers to the array 'v' as separate elements 
        v.add(0);
        v.add(1);
        int firstNumber = 0, secondNumber = 1, FirstplusSecond;
        for (int i = 2; i < 30; i++) {
            FirstplusSecond = firstNumber + secondNumber;
            v.add(FirstplusSecond);
            firstNumber = secondNumber;
            secondNumber = FirstplusSecond;
        }

        //prints the array 'v'
        System.out.println(v.toString());

        //reverses the elements in array 'v'
        v.reverse();

        //creates a clone of the array called 'clone'
        MyVector clone = v.clone();

        //prints the array 'clone'
        System.out.println(clone.toString());

        //removes elements at all odd index's in the array 'v'
        for (int i = 1; i < v.size(); i++) {
            v.remove(i);
        }

        //prints the array 'v'
        System.out.println(v.toString());

        //reverses the elements in array 'clone'
        clone.reverse();

        //prints the array 'clone'
        System.out.println(clone.toString());

        //adds all elements of array 'clone' to the end of array 'v'
        v.addAll(clone);

        //prints the array 'v'
        System.out.println(v.toString());
    }
}
