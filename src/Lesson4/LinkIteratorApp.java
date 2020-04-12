package Lesson4;

public class LinkIteratorApp {
    public static void main(String[] args) {
        MyLinkedListIterable<Character> list = new MyLinkedListIterable<>();
        list.addFirst('c');
        list.addFirst('b');
        if(list.contains('b')){
            list.addFirst('a');
        }
        System.out.println(list);
        list.addLast('d');
        list.removeFirst();
        list.remove('c');
        list.add(2, 'e');
        System.out.println(list);
        list.set(1, 'c');
        System.out.println(list.get(1));
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.addLast('o');
        list.addFirst('k');
        list.addLast('p');
        System.out.println(list);
    }
}
