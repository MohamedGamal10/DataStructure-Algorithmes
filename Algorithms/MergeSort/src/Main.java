
public class Main {
    public static void main(String[] args) {

        int [] array = {9,5,1,4};
        System.out.println("Given Array");
        Func.printArray(array);

        System.out.println("\nSorted array");
        Func ob = new Func();
        ob.MergeSort(array, 0, array.length-1);
        ob.printArray(array);

    }
}