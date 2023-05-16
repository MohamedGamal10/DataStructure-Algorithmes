public class Main {
    public static void main(String[] args) {
        /* BinaryTree */

        // BinaryTree<Character> tree = new BinaryTree<Character>();
        // tree.Insert('A');
        // tree.Insert('B');
        // tree.Insert('C');
        // tree.Insert('D');
        // tree.Insert('E');
        // tree.Insert('F');
        // tree.Insert('G');
        // tree.Insert('H');
        // tree.Insert('I');
        // tree.printBinaryTree();
        // System.out.println("Height: " + tree.Height());
        // tree.PreOrder();
        // tree.InOrder();
        // tree.PostOrder();

        /* BinaryTree */

        /*Binary Search Tree */
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        //tree.BSInsert(4);
        //tree.BSInsert(2);
        //tree.BSInsert(1);
        //tree.BSInsert(3);
        //tree.BSInsert(5);
        //tree.BSInsert(6 );
        //tree.printBinaryTree();
        //System.out.println(tree.IsExist(3));

        //tree.BSDelete(6);
        //tree.printBinaryTree();

        tree.BSInsert(1);
        tree.BSInsert(2);
        tree.BSInsert(3);
        tree.BSInsert(4);
        tree.BSInsert(5);
        tree.BSInsert(6);
        tree.BSInsert(7);
        tree.printBinaryTree();

        tree.Balance();
        tree.printBinaryTree();
        /*Binary Search Tree */

    }
}