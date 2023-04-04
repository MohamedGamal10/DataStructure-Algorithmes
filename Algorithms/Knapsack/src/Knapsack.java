import java.util.ArrayList;
import java.util.List;

public class Knapsack {
    public float maxCapacity = 0;
    public float currentCapacity = 0;
    public float totalValue = 0;
    public List<item> items = new ArrayList<item>();

    public Knapsack (int maxCapacity){
        this.maxCapacity = maxCapacity;
    }

    public void add_item (item newItem){

        //Condition if I can put new item or capacity is full
        if (newItem.weight > this.maxCapacity - this.currentCapacity){
            //take a Piece of it
            float diff = this.maxCapacity - this.currentCapacity;
            newItem.weight = diff;

            //update its value to be updated with its new weight
            newItem.value = diff * newItem.ratio;
        }

        //Add newitem to Knapsack items Array
        this.items.add(newItem);
        this.currentCapacity += newItem.weight;
        this.totalValue += newItem.value;
    }
}
