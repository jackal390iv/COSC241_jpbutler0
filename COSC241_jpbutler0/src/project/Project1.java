/**
 *
 * @author Jackal
 */
package project;

import collection.MySet;

public class Project1 {

    public static void test() {

        /**
         * creates a temp-set to use with method operations
         */
        MySet myClone = new MySet();
        /**
         * creates a MySet of the first 25 fibonacci numbers
         */
        MySet fibonacciNum = new MySet();
        fibonacciNum.add(0);
        fibonacciNum.add(1);
        int firstNumber = 0, secondNumber = 1, FirstplusSecond;
        for (int i = 0; i < 24; i++) {
            FirstplusSecond = firstNumber + secondNumber;
            fibonacciNum.add(FirstplusSecond);
            firstNumber = secondNumber;
            secondNumber = FirstplusSecond;
        }
        System.out.println(fibonacciNum.toString());

        /**
         * creates a MySet of the first 25 perfect square numbers
         */
        MySet perfectSquare = new MySet();
        for (int i = 1; i < 26; i++) {
            perfectSquare.add(i * i);
        }
        System.out.println(perfectSquare.toString());

        /**
         * prints the intersection of fibonnacci numbers set and perfect square
         * numbers set
         */
        myClone.addAll(fibonacciNum);
        myClone.retainAll(perfectSquare);
        System.out.println(myClone.toString());

        /**
         * prints the symmetric difference of fibonnacci numbers set and perfect
         * square numbers set
         */
        myClone.clear();
        myClone.addAll(fibonacciNum);
        myClone.symmetricDifference(perfectSquare);
        System.out.println(myClone.toString());

        /**
         * prints the union of fibonnacci numbers set and perfect square numbers
         * set
         */
        myClone.clear();
        myClone.addAll(fibonacciNum);
        myClone.addAll(perfectSquare);
        System.out.println(myClone.toString());
    }
}
