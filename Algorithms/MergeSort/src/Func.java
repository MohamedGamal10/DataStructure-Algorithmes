public class Func {
    // MergeSort Function
        // Inputs (array, StartPoint, EndPoint)
    public static void MergeSort(int [] OriginalArray, int StartPoint, int EndPoint){
            // Base Case : Exit if EndPoint <= Start
        if (EndPoint <= StartPoint) return;

            // Calculate MidPoint
            int MidPoint = (EndPoint + StartPoint) / 2;

            // MergeSortFunction(array, StartPoint, MidPoint) For LeftArray
            MergeSort(OriginalArray, StartPoint, MidPoint);

            // MergeSortFunction(array, MidPoint + 1, EndPoint) For RightArray
            MergeSort(OriginalArray, MidPoint + 1, EndPoint);

            // MergeFunction(array, StartPoint, MidPoint, EndPoint)
            Merge(OriginalArray, StartPoint, MidPoint, EndPoint);

        }

    //Merge Function
        // Inputs(array, StartPoint, MidPoint, EndPoint)

    public static void Merge(int [] OriginalArray, int StartPoint, int MidPoint, int EndPoint){
            // Create Two Array
                //Create Counters to itreate on Arrays
        int LeftArrayCounter ,RightArrayCounter, OriginalArrayCounter;

                //Calculate Arrays Length
        int LeftArrayLength = MidPoint - StartPoint + 1;
        int RightArrayLength = EndPoint - MidPoint;

                //Create Arrays, insert values in Left and Right array
        int [] LeftArray = new int [LeftArrayLength];
        int [] RightArray = new int [RightArrayLength];

        for(LeftArrayCounter = 0; LeftArrayCounter < LeftArrayLength; LeftArrayCounter++){
            LeftArray[LeftArrayCounter] = OriginalArray[StartPoint + LeftArrayCounter];
        }

        for(RightArrayCounter = 0; RightArrayCounter < RightArrayLength; RightArrayCounter++){
            RightArray[RightArrayCounter] = OriginalArray[ MidPoint + 1 + RightArrayCounter];
        }

            // Compare items and sort in the original array
        LeftArrayCounter =  RightArrayCounter = 0;
        OriginalArrayCounter = StartPoint;

        while (LeftArrayCounter < LeftArrayLength && RightArrayCounter < RightArrayLength){

            if(LeftArray[LeftArrayCounter] < RightArray[RightArrayCounter]){
                OriginalArray[OriginalArrayCounter] = LeftArray[LeftArrayCounter];
                LeftArrayCounter++;
            }else{
                OriginalArray[OriginalArrayCounter] = RightArray[RightArrayCounter];
                RightArrayCounter++;
            }

            OriginalArrayCounter++;


        }
            // Move Remain items
        while (LeftArrayCounter < LeftArrayLength){
            OriginalArray[OriginalArrayCounter] = LeftArray[LeftArrayCounter];
            LeftArrayCounter++;
            OriginalArrayCounter++;
        }

        while (RightArrayCounter < RightArrayLength){
            OriginalArray[OriginalArrayCounter] = RightArray[RightArrayCounter];
            RightArrayCounter++;
            OriginalArrayCounter++;
        }

    }

    // A utility function to print array of size n
    public static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }


}
