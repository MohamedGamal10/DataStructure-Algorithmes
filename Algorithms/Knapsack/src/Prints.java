import java.util.ArrayList;

public class Prints {

    public static void PrintItems (item [] ArrayItems){
        for (int i = 0; i < ArrayItems.length; i++) {

            System.out.println(" [ " +"Name : " + ArrayItems[i].name + "  Value : " + ArrayItems[i].value + "  Weight : " + ArrayItems[i].weight + "  Ratio : " + ArrayItems[i].ratio + " ] ");

        }
    }

    public static void PrintBag (Knapsack Knapsack){
        for (int i = 0; i < Knapsack.items.size(); i++) {

            System.out.println(" [ " +"Name : " + Knapsack.items.get(i).name + "  Value : " + Knapsack.items.get(i).value + "  Weight : " + Knapsack.items.get(i).weight + " ] ");

        }
    }
}
