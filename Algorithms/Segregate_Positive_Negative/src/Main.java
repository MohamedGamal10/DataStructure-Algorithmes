public class Main {
    public static void main(String[] args) {

        int [] array = {6,-5,12,10,-9,-1};
        System.out.println("Given Array");
        Segregate.printArray(array);

        System.out.println("\nSorted array");
        Segregate.Segregate(array, 0, array.length-1);
        Segregate.printArray(array);

    }
}