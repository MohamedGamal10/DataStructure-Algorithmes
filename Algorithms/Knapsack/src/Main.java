import java.util.*;
public class Main {
    public static void main(String[] args) {

        // Define Inputs
        int [] values = {4,9,12,11,6,5};
        int [] weight = {1,2,10,4,3,5};
        item [] items = new item[values.length];

        //convert inputs to items objects and insert them to items array
        for (int i = 0; i < items.length; i++){
            item newitem = new item(values[i], weight[i],"#"+i );
            items[i] = newitem;
        }

        //Sort Array of items
        Sort.MergeSort(items, 0, items.length-1);
        System.out.println("All Items --------------------------");
        Prints.PrintItems(items);

        //While not reach to max capacity , Add new items, Start Choice
        Knapsack Bag = new Knapsack(12);
        int j = 0;
        while (Bag.currentCapacity < Bag.maxCapacity){
            Bag.add_item(items[j]);
            j++;
        }
        System.out.println("Selected Items --------------------------");
        System.out.println("Total Value : " + Bag.totalValue);
        System.out.println("Current Capacity : " + Bag.currentCapacity);
        System.out.println("Items -------------");
        Prints.PrintBag(Bag);

    }
}