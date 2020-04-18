package Lesson5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Результат возведения в степень: " + exponent(2, 3));

        MyArr arr = new MyArr(9);
        arr.insert(1);
        arr.insert(2);
        arr.insert(3);
        arr.insert(4);
        arr.insert(5);
        arr.insert(6);
        arr.insert(7);
        arr.insert(8);
        arr.insert(9);

        int search = 8;
        String result = arr.binaryFind(search);
        System.out.println("Результат поиска: " + result);

        List<Thing> list = new ArrayList<>();
        list.add(new Thing("Book", 1, 600));
        list.add(new Thing("Binoculars", 2, 5000));
        list.add(new Thing("first_aid_kit", 3, 1500));
        list.add(new Thing("Notebook", 2, 40000));
        list.add(new Thing("Bowler_hut", 2, 500));
        Backpack backpack = new Backpack(5);
        backpack.calcBestSet(list);
        list = backpack.getBestSet();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).name + " " + list.get(i).price);
        }
        System.out.println("Count: " + backpack.count);

    }

    static int exponent(int a, int b) {
        if (b <= 1) {
            return a;
        }
        return exponent(a, b - 1) * a;
    }
}
