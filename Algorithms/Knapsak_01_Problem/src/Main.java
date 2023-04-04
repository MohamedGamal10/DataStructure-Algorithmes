import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //Define Inputs
        //Add empty item to make code easy for reading
        item [] items = {new item(0,0,"#0"),
                         new item(1,4,"#1"),
                         new item(3,9,"#2"),
                         new item(5,12,"#3"),
                         new item(4,11,"#4")};

        int Max_Weight = 8;

        //Result Table
        int [] [] dp = new int[items.length+1] [Max_Weight+1];

        //Calculation
        for (int i = 0; i < items.length ; i++) {
            for (int j = 0; j <= Max_Weight; j++) {

                //add Column and Row with zeros
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }

                else if (items[i].Weight <= j) {
                    dp[i][j] = Math.max(dp[i-1][j], items[i].Profit + dp[i-1][j-items[i].Weight]);
                }

                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        // Print dp
        for (int[] row : dp)
            System.out.println(Arrays.toString(row));

        System.out.println("Max Profit : " + dp[items.length-1][Max_Weight]);


        //Get items
        ArrayList Solution = new ArrayList<>();
        int i = items.length - 1;
        int j = Max_Weight;
        int remain = Max_Weight;

        while (remain >= 0 && j>0){
            if(dp[i][j] > dp[i-1][j]){
                Solution.add(items[i].Name);
                remain = remain - items[i].Weight;
                j=remain;
                i--;
            }else {
                i--;
            }

        }
        System.out.println("Items : " + Solution);

    }
}