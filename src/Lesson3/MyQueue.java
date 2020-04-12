package Lesson3;

public class MyQueue {

    static final int DEFAULT_MARK_BACK = -1;
    static final int DEFAULT_MARK_FRONT = 0;
    private int[] data;
    private int currentSize;

    private int markFront;
    private int markBack;

    public MyQueue(int maxSize) {
        this.currentSize = 0;
        this.markFront = DEFAULT_MARK_FRONT;
        this.markBack = DEFAULT_MARK_BACK;
        this.data = new int[maxSize];
    }

    public void insert(int value) {
        if(markFront == data.length-1){
            markBack = DEFAULT_MARK_BACK;
        }
        data[++markBack] = value;
        currentSize++;
    }

    public int remove() {
        int removedElement = data[markFront++];
        if(markFront == data.length){
            markFront = DEFAULT_MARK_FRONT;
        }
        currentSize--;
        return  removedElement;
    }

    public int getSize() {
        return currentSize;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean isFull() {
        return currentSize == data.length;
    }
}
