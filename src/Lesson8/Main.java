package Lesson8;

public class Main {
    public static void main(String[] args) {

        ChainingHashMap<Integer ,String> map = new ChainingHashMap<>();
        map.put(1,"one");
        map.put(2,"two");
        map.put(12,"12");
        map.put(15,"15");
        System.out.println(map.remove(1));
        System.out.println(map.remove(12));
        System.out.println(map);

    }
}
