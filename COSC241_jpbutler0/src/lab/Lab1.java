/**
 *
 * @author Jackal
 */
package lab;

import java.util.Vector;

public class Lab1 {

    public Lab1() {
    }

    public static void test(Vector vector2) {
        Vector<Object> vector = new Vector<Object>();

        int primitiveInt = 241;
        Integer wrapperInt = new Integer(1234);
        String str = "Jon Butler";
        vector.add(primitiveInt);
        vector.add(wrapperInt);
        vector.add(str);
        vector.add(2, new Integer(2128));

        System.out.println("The element of vector: "
                + vector);
        System.out.println("The size of vector is: "
                + vector.size());
        System.out.println("The element at position 2 is: "
                + vector.elementAt(2));
        System.out.println("The first element of vector is: "
                + vector.firstElement());
        System.out.println("The last element of vector is: "
                + vector.lastElement());
        vector.removeElementAt(1);
        System.out.println("The elements of vector: "
                + vector);
        System.out.println("The size of vector is: "
                + vector.size());
        System.out.println("The element at position 2 is: "
                + vector.elementAt(2));
        System.out.println("The first element of vector is: "
                + vector.firstElement());
        System.out.println("The last element of vector is: "
                + vector.lastElement());

        //clears vector of elements
        vector.clear();

        //
        int temps;
        for (int j = 0; j < vector2.size(); j++) {
            temps = (int) vector2.get(j);
            vector.add(temps);
        }

        //prints elements of vector	
        System.out.println("The elements of vector: " + vector);

        /* 	this block of code goes through vector and removes all odd indices 
         to elaborate it removes the first element, every thing moves left to fill the empty block
         then the for loop moves one over from that point and removes the next element which 
         was originally the third. An example: it removes '0', '1' moves left along with every other 
         element, the for loop moves over one to '2' and removes it, etc. (continue cycle)	*/
        for (int i = 1; i < vector.size(); i++) {
            vector.remove(i);
        }

        //prints elements of vector
        System.out.println("The elements of vector: " + vector);
    }
}
