package Lesson3;

public class Main {

    private static final int ARR_SIZE = 10;

    public static void main(String[] args) {

        MyQueue myQueue = new MyQueue(ARR_SIZE);
        MyDeque myDeque = new MyDeque(ARR_SIZE);
        StringInverse inverse = new StringInverse();

        inverse.printStackToString(inverse.initializeStack());

        initializeQueue(myQueue);
        initializeDequeue(myDeque);

        while (!myDeque.isEmpty()) {
            System.out.println(myDeque.removeRight());
            System.out.println(myDeque.removeLeft());
        }
    }

    static void initializeDequeue(MyDeque myDeque) {
        for (int i = 0; i < ARR_SIZE/2; i++) {
            myDeque.insertLeft(i);
            myDeque.insertRight(i);
        }
    }

    static void initializeQueue(MyQueue myQueue) {
        for (int i = 0; i < ARR_SIZE; i++) {
            myQueue.insert(i);
        }
    }
}
