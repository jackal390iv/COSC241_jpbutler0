/**
 *
 * @author Jackal
 */
package project;

import java.util.Scanner;
import collection.MyVector;
import java.io.*;

/**
 * This class scans 'EnglishWordList' adding all 7 character words to vec1, and
 * converts those words into the number equivalent and stores them in vec2. Then
 * it searches vec2 for all numbers that match 'String numbers[]' and prints the
 * number currently being processed followed by the correlating word values
 */
public class Project2 {

    public static void test(String numbers[]) {

        System.currentTimeMillis();

        File doc = new File("../EnglishWordList.txt");

        Scanner kbin = null;
        try {
            kbin = new Scanner(doc);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int i = 0;
        String temp = null;
        MyVector vec1 = new MyVector();
        MyVector vec2 = new MyVector();
        while (kbin.hasNextLine()) {
            temp = kbin.nextLine();
            if (temp.length() == 7) {
                vec1.add(temp);
                vec2.add(temp.replace("a", "2").replaceAll("b", "2").replaceAll("c", "2").replaceAll("d", "3").replaceAll("e", "3").replaceAll("f", "3").replaceAll("g", "4").replaceAll("h", "4").replaceAll("i", "4").replaceAll("j", "5").replaceAll("k", "5").replaceAll("l", "5").replaceAll("m", "6").replaceAll("n", "6").replaceAll("o", "6").replaceAll("p", "7").replaceAll("q", "7").replaceAll("r", "7").replaceAll("s", "7").replaceAll("t", "8").replaceAll("u", "8").replaceAll("v", "8").replaceAll("w", "9").replaceAll("x", "9").replaceAll("y", "9").replaceAll("z", "9"));
                i++;
            }
        }

        System.out.println("Your possible phone words are as follows: ");
        for (int k = 0; k < numbers.length; k++) {
            System.out.println("\n" + numbers[k] + ":");
            for (int j = 0; j < vec2.size(); j++) {
                if (vec2.get(j).equals(numbers[k])) {
                    System.out.println(vec1.get(j));
                }
            }
        }

    }
}
