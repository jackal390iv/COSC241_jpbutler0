/**
 *
 * @author Jackal
 */
package lab;

import java.util.Scanner;

public class Lab4 {

    /**
     * this method asks for a string to be tested whether it is a palindrome or
     * not. If it is "Your String is Palindrome!!" is printed, if not "Your
     * String is not Palindrome.." is printed
     *
     * @param args, no parameter needed
     */
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String kbin;
        System.out.println("Please input your string: ");
        kbin = scan.nextLine();
        kbin = kbin.replaceAll(" ", "");
        boolean value = isPalindrome(kbin);
        if (value == true) {
            System.out.println("Your String is Palindrome!!");
        }
        if (value == false) {
            System.out.println("Your String is not Palindrome..");
        }
    }

    /**
     * this method compares char in string to determine if the string is
     * palindrome
     *
     * @param sting "kbin" to be tested
     * @return true if string is a Palindrome, and false if it is not.
     */
    public static boolean isPalindrome(String kbin) {
        int low = 0;
        int high = kbin.length() - 1;
        String temp;

        if ((kbin.charAt(low) == kbin.charAt(high)) && ((low + 1) == high)) {
            return true;
        } else if ((kbin.charAt(low) == kbin.charAt(high)) && (low == high)) {
            return true;
        } else if ((kbin.charAt(low) != kbin.charAt(high))) {
            return false;

        } else {
            temp = kbin.substring(low + 1, high);
            return isPalindrome(temp);
        }
    }
}
