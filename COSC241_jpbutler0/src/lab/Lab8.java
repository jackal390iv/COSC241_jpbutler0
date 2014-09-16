package lab;

import collection.DeQue;

public class Lab8 {

    public static void test() {

        DeQue dque = new DeQue();
        String str = "amanaplanacanalpanama";

        for (int i = 0; i < str.length(); i++) {
            dque.insertBack(str.charAt(i));
        }

        boolean val = true;

        while ((!(dque.isEmpty())) && (val == true)) {
            Object ref1 = dque.removeBack();
            if (dque.isEmpty()) {
                break;
            }
            Object ref2 = dque.removeFront();

            if (!(ref1.equals(ref2))) {
                val = false;
            }
        }

        if (val == true) {
            System.out.println("'amanaplanacanalpanama' is Palindrome");
        } else if (val == false) {
            System.out.println("'amanaplanacanalpanama' is not Palindrome");
        }
    }
}
