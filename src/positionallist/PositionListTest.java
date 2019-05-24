package positionallist;

public class PositionListTest {

    public static void main(String[] args) {
        LinkedPositionalList<Integer> list = new LinkedPositionalList<>();

        list.addFirst(5);
        list.addLast(3);
        System.out.println("Size of the list: " + list.size());

    }
}
