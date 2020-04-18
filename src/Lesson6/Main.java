package Lesson6;

public class Main
{
    public static void main( String[] args ) {
        int balanced = 0;
        int notBalanced = 0;
        for (int i = 0; i < 20; i++) {
            MyTreeMap<Integer, Integer> map = new MyTreeMap<>();
            while (true){
                if (map.height() >= 7) {
                    break;
                }
                Integer val = (int) (Math.random() * 200 - 100);
                map.put(val, val);
            }
            if (map.isBalanced()) balanced++;
            else notBalanced++;
        }
        System.out.println("Процент несбалансированных деревьев: " + (float) notBalanced / (balanced + notBalanced) * 100);
    }
}

