package Lesson2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[1000000];
        for (int i = 0; i < arr.length; i++) {
            Random random = new Random();
            arr[i] = random.nextInt(arr.length);
        }

        System.out.println("Массив заполнен");
        int[] arrCopy = new int[arr.length];
        System.arraycopy(arr, 0, arrCopy, 0, arr.length);

        int[] arrCopy2 = new int[arr.length];
        System.arraycopy(arrCopy, 0, arrCopy2, 0, arrCopy.length);


        System.out.println("Начинаю сортировку sortBubble");
        long time1 = System.currentTimeMillis();
        sortBubble(arr);
        System.out.println("Время выполнения метода sortBubble: " + (System.currentTimeMillis() - time1) + " мс");


        System.out.println("Начинаю сортировку sortSelect");
        long time2 = System.currentTimeMillis();
        sortSelect(arrCopy);
        System.out.println("Время выполнения метода sortSelect: " + (System.currentTimeMillis() - time2) + " мс");


        System.out.println("Начинаю сортировку sortInsert");
        long time3 = System.currentTimeMillis();
        sortInsert(arrCopy2);
        System.out.println("Время выполнения метода sortInsert: " + (System.currentTimeMillis() - time3) + " мс");

    }

    public static void sortBubble(int[] arr) {
        int out, in;
        for (out = arr.length - 1; out >= 1; out--) {
            for (in = 0; in < out; in++) {
                if (arr[in] > arr[in + 1]) {
                    change(arr, in, in + 1);
                }
            }
        }
    }

    private static void change(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }


    public static void sortSelect(int[] arr) {
        int out, in, mark;
        for (out = 0; out < arr.length; out++) {
            mark = out;
            for (in = out + 1; in < arr.length; in++) {
                if (arr[in] < arr[mark]) {
                    mark = in;
                }
            }
            change(arr, out, mark);
        }
    }

    public static void sortInsert(int[] arr) {
        int in, out;
        for (out = 1; out < arr.length; out++) {
            int temp = arr[out];
            in = out;
            while (in > 0 && arr[in - 1] >= temp) {
                arr[in] = arr[in - 1];
                --in;
            }
            arr[in] = temp;
        }
    }
}
