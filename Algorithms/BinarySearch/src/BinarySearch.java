public class BinarySearch {
    public static int Calculate (int [] array, int Key){
        //Set Low and High values
        int Low = 0;
        int High = array.length -1 ;

        // Calculation
        while (Low <= High){
            int Mid = (Low + High) /2;
            if (Key == array[Mid]){
                return Mid;
            }else{
                if (Key > array[Mid]){
                    Low = Mid +1;
                }else{
                    High = Mid - 1;
                }
            }
        }
        return -1;
    }
}
