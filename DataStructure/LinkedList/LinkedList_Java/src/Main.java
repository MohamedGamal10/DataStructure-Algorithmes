public class Main {
    public static void main(String[] args) {

        LinkdeList list = new LinkdeList(true);
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(3);
        list.printList();
        System.out.println("length: " + list.length);

    }
}