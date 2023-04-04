import java.util.Arrays;
public class InsertionSort {

    public static String calc (int [] X){
        //initalization
        int key = 0;
        int temp = 0;

        //Calculation
        for (int i =1; i<X.length; i++){
            key = X[i];
            for(int j=i-1; j>=0; --j) {
                if (X[j]>key) {
                    X[j + 1] = X[j];
                }
                else {
                    temp = j;
                    break;
                }
            }
            X[temp+1] = key;

        }

        return Arrays.toString(X);
    }
}
