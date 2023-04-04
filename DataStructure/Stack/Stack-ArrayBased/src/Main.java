public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack(false);
        System.out.println("isEmpty : " + stack.isEmpty());

        stack.push(12);
        stack.push(23);
        stack.push(34);
        System.out.println("isEmpty : " + stack.isEmpty());
        //System.out.println("size : " + stack.size());

        stack.print();
        stack.push(45);

        //System.out.println("pop : " + stack.pop());
        //System.out.println("size : " + stack.size());
        stack.print();

        //System.out.println("peek : " + stack.peek());
        //System.out.println("size : " + stack.size());
        //stack.print();

        while (!stack.isEmpty()){
            System.out.println("pop : " + stack.pop());
            System.out.println("size : " + stack.size());
            stack.print();

        }

    }
}