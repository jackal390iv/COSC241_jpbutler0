package project;

import collection.MyQueue;
import collection.MyStack;
import collection.SLListNode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import lab.Lab7;

public class Project3 {

    private static File doc = new File("../Project3Input.txt");
    private static MyQueue que = new MyQueue();
    private static MyQueue que2 = new MyQueue();
    private static MyStack sta = new MyStack();
    private static String prefix = "";
    private static StringBuilder strbuild = new StringBuilder();
    private static Object key1 = "/";
    private static Object key2 = "*";
    private static Object key3 = "%";
    private static Object key4 = "-";
    private static Object key5 = "+";

    public static void test() {

        strbuild.append("Project 3:" + "\n\n");

        Scanner kbin = null;
        try {
            kbin = new Scanner(doc);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while ((kbin.hasNext())) {
            String ref1 = kbin.nextLine().replaceAll(" ", "").replace("(", "")
                    .replace(")", "");
            if (ref1.isEmpty()) {
                strbuild.append("Invalid infix expression." + "\n");
            } else {
                sorter(ref1);

                strbuild.append("Infix: " + ref1 + "\r");

                if (ref1.endsWith("*") || ref1.endsWith("/")
                        || ref1.endsWith("-") || ref1.endsWith("+")) {
                    strbuild.append("Invalid Expression!" + "\n");
                } else {
                    int sum = 0;
                    int a = 0;
                    int b = 0;
                    char d = 0;
                    while ((que2.getFront() != null) && (sta.peek() != null)) {
                        while ((que2.getFront() != key1)
                                || (que2.getFront() != key2)
                                || (que2.getFront() != key3)
                                || (que2.getFront() != key4)
                                || (que2.getFront() != key5)) {
                            sta.push(que.removeFront());
                        }
                        a = (int) sta.pop();
                        b = (int) sta.pop();
                        d = (char) que.removeFront();

                        if (d == ('/')) {
                            sum += a / b;
                        } else if (d == ('*')) {
                            sum += a * b;
                        } else if (d == ('%')) {
                            sum += a % b;
                        } else if (d == ('*')) {
                            sum += a * b;
                        } else if (d == ('-')) {
                            sum += a - b;
                        } else if (d == ('+')) {
                            sum += a + b;
                        }
                    }
                    strbuild.append("Sum: " + sum + "\n\n");
                }
                que.clear();
                que2.clear();
            }
        }
        try {
            Files.write(Paths.get("Project3Output_jpbutler0.txt"), strbuild
                    .toString().getBytes());
        } catch (IOException ex) {
            Logger.getLogger(Lab7.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(strbuild.toString());
    }

    public static void sorter(String ref1) {

        int i = 0;
        int length = ref1.length();
        for (; i < length; i++) {
            char cha = ref1.charAt(i);

            if (cha == ('-' | '+')) {
                while ((sta.peek() == key1) || (sta.peek() == key2)
                        || (sta.peek() == key3) || (sta.peek() == key4)
                        || (sta.peek() == key5)) {
                    que.insertBack(sta.pop());
                    que2.insertBack(sta.pop());
                }
                sta.push(cha);
                if (i == (ref1.length() - 1)) {
                    while (sta.peek() != null) {
                        que.insertBack(sta.pop());
                        que2.insertBack(sta.pop());
                    }
                }
            }

            if (cha == ('%' | '/' | '*')) {
                while ((sta.peek() == key1) || (sta.peek() == key2)
                        || (sta.peek() == key3)) {
                    que.insertBack(sta.pop());
                    que2.insertBack(sta.pop());
                }
                sta.push(cha);
                if (i == (ref1.length() - 1)) {
                    while (sta.peek() != null) {
                        que.insertBack(sta.pop());
                        que2.insertBack(sta.pop());
                    }
                }
            } else if (!(cha == ('%' | '/' | '*' | '-' | '+'))) {
                que.insertBack(cha);
                que2.insertBack(cha);
            }
        }

        if (i == (length)) {
            Object line = "";
            while (!(que.isEmpty())) {
                line = que.removeFront();
                if (prefix == null) {
                    prefix = "" + line;
                } else {
                    prefix = prefix + line;
                }
            }
            strbuild.append("\n" + "Prefix: " + prefix + "\r");
            prefix = "";
            sta.clear();
        }
    }

}
