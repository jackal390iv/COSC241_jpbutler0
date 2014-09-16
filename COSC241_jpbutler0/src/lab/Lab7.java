package lab;

import collection.MyQueue;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import collection.MyStack;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lab7 {

    public static void test() {

        Random rand = new Random(123456789);
        MyStack stack = new MyStack();
        MyQueue que = new MyQueue();

        for (int i = 0; i < 30; i++) {
            Integer tmp = rand.nextInt();
            stack.push(tmp);
            que.insertBack(tmp);
        }

        for (int i = 0; i < 20; i++) {
            stack.pop();
            que.removeFront();
        }

        StringBuilder strbuild = new StringBuilder();
        Object line = null;

        strbuild.append("MyStack:" + "\r\n");
        while (!stack.isEmpty()) {
            strbuild.append(stack.pop().toString());
            strbuild.append("\r\n");
        }
        strbuild.append("\n" + "MyQueue:" + "\r\n");
        while (!que.isEmpty()) {
            strbuild.append(que.removeFront().toString());
            strbuild.append("\r\n");
        }
        try {
            Files.write(Paths.get("Lab7Output_jpbutler0.txt"), strbuild.toString().getBytes());
        } catch (IOException ex) {
            Logger.getLogger(Lab7.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(strbuild.toString());
    }
}
