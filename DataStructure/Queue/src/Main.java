
public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();
        System.out.println("isEmpty : " + queue.isEmpty());
        queue.enqueue(8);
        queue.enqueue(16);
        queue.enqueue(32);
        queue.enqueue(64);
        System.out.println("isEmpty : " + queue.isEmpty());
        System.out.println("Size : " + queue.size());
        queue.print();

        while (!queue.isEmpty()){
            System.out.println("Peek : " + queue.peek() );
            System.out.println("Dequeue : " + queue.dequeue() );
            System.out.println("Size : " + queue.size() );
            queue.print();
        }

    }
}