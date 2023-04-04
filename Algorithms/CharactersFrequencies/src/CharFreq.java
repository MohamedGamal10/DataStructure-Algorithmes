import java.util.*;

public class CharFreq {

    public static void ASCIIMethod(String Mesg){

        System.out.println("ASCIIMethod");

        //Define Result Array
        int [] Freq = new int[127];

        //Loop to get Ascii code of each message character and insert into array
        for (int i = 0; i < Mesg.length();i++)
        {
            int current_code = (int) Mesg.charAt(i) ;
            Freq[current_code]++;
        }

        //Loop To print Final Result
        for (int i = 0; i < Freq.length; i++){
            if (Freq[i]>0){
                char ch = (char) i;
                System.out.print(ch + " ");
                System.out.println(Freq[i]);
            }
        }


    }

    public static void AnyCodeMethod (String Mesg ){
        System.out.println("AnyCodeMethod");

        //Create HashTable As Final Result
        Hashtable Freq = new Hashtable();

        //Loop to get code of each message character and insert into Hashtable
        for (int i = 0; i < Mesg.length(); i++){
            if (Freq.containsKey(Mesg.charAt(i))){
                Freq.put(Mesg.charAt(i), (int)Freq.get(Mesg.charAt(i)) + 1);
            }
            else {
                Freq.put(Mesg.charAt(i), 1 );
            }
        }

        //Loop To print Final Result
        Freq.forEach(
                (k, v) -> System.out.println(k +" "+ v));

        //Sort Results
        SortHash(Freq);


    }

    public static void SortHash(Hashtable Freq){

        //To sort Hashtable we convert it to n-dimension array
        int [] [] FreqArray = new int [Freq.size()][2];
        Enumeration Key = Freq.keys();
        Enumeration Value = Freq.elements();

        int i = 0;
        while (Key.hasMoreElements() & Value.hasMoreElements()) {
            FreqArray[i][0]  = (int)(char) Key.nextElement();
            FreqArray[i][1]  = (int) Value.nextElement();
            i++;
        }

        //Sort using Merge Sort
        Sort(FreqArray,0, Freq.size()-1);

        //Print Result of Merge Sort
        System.out.println("Print Sorted Data");
        for (i =0; i< Freq.size(); i++){
            System.out.print((char) FreqArray[i][0] + " " );
            System.out.println(FreqArray[i][1]);
        }

    }

    // MergeSort Function
    // Inputs (array, StartPoint, EndPoint)
    public static void Sort (int [] [] array, int start, int end){
        // Base Case : Exit if EndPoint <= Start
        if (end <= start) return;

        // Calculate MidPoint
        int midpoint = (end+start)/2;

        // MergeSortFunction(array, StartPoint, MidPoint) For LeftArray
        Sort(array, start, midpoint);

        // MergeSortFunction(array, MidPoint + 1, EndPoint) For RightArray
        Sort(array, midpoint+1, end);

        // MergeFunction(array, StartPoint, MidPoint, EndPoint)
        Merge(array, start, midpoint, end);

    }

    //Merge Function
    // Inputs(array, StartPoint, MidPoint, EndPoint)
    public static void Merge(int [] [] array, int start, int mid, int end){

        // Create Two Array
            //Create Counters to itreate on Arrays
        int i, j, k = 0;

            //Calculate Arrays Length
        int left_length = mid - start +1;
        int right_length = end -mid;

            //Create Arrays, insert values in Left and Right array
        int [][] left_array = new int[left_length][2];
        int [][] right_array = new int[right_length][2];

        for(i=0; i<left_array.length; i++){
            left_array[i][0] = array[start+i][0];
            left_array[i][1] = array[start+i][1];
        }

        for(j=0; j<right_array.length; j++){
            right_array[j][0] = array[mid+1+j][0];
            right_array[j][1] = array[mid+1+j][1];
        }

            // Compare items and sort in the original array
        i=j=0;
        k=start;

        while(i<left_length && j <right_length){
            if(left_array[i][1] < right_array[j][1]){
                array[k][0] = left_array[i][0];
                array[k][1] = left_array[i][1];
                i++;
            }else {
                array[k][0] = right_array[j][0];
                array[k][1] = right_array[j][1];
                j++;
            }
            k++;
        }

            // Move Remain items
        while (i<left_length){
            array[k][0] = left_array[i][0];
            array[k][1] = left_array[i][1];
            i++;
            k++;
        }
        while (j<right_length){
            array[k][0] = right_array[j][0];
            array[k][1] = right_array[j][1];
            j++;
            k++;
        }


    }
























}
