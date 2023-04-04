import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //Strings to compare
        String text_01 = "HELLOWORLD";
        String text_02 = "OHELOD";

        //Get length
        int n = text_01.length();
        int m = text_02.length();

        //add Column and Row with zeros
        text_01 = " "+text_01;
        text_02 = " " +text_02;

        //Result Table
        int [] [] dp = new int[m+1] [n+1];

        //Calculation
        for (int i = 0; i <=m ; i++) {
            for (int j = 0; j <=n ; j++) {

                //add Column and Row with zeros
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
                //IF Not Match
                else if (text_02.charAt(i) == text_01.charAt(j)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                //IF Match
                else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }

        //Print Length of LCS
        System.out.println(dp[m][n]);

        //Get LCS

        // Start from the bottom right
        String str = "";
        int i = m;
        int j = n;
        while (i > 0 && j > 0){
            // if current value > left value
            // -- -- //the current value inherited from Top
            if(dp[i][j] > dp[i][j-1]){
                if(dp[i][j] == dp[i-1][j]){
                    // -- -- Move to top row
                    i--;
                }
                // -- else
                // -- -- //Current Value is origin of match
                else {
                    // -- -- add the char to the solution
                    str = text_02.charAt(i) + str;

                    // -- -- move to the top row
                    i--;
                    // -- -- Move to left column
                    j--;
                }

            }
            //Move to left column
            else {
                j--;
            }
        }

        //Print Length of LCS
        System.out.println(str);







    }
}