package Lesson3;

import java.util.Scanner;

public class StringInverse {

    private String s;
    private MyStack myStack;

    public void printStackToString(MyStack myStack) {
        while (myStack.isEmpty()) {
            System.out.print(myStack.pop());

        }
        System.out.println();
    }

    public MyStack initializeStack() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        this.myStack = new MyStack(s.length());
        for (int i = 0; i < s.length(); i++) {
            this.myStack.push(s.charAt(i));
        }
        return this.myStack;
    }
}
