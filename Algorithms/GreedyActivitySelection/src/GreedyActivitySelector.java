import java.util.ArrayList;
public class GreedyActivitySelector {

    public static ArrayList<Integer> GreedyActivitySelector (int [] Start, int [] End){

        ArrayList<Integer> Result = new ArrayList<Integer>();
        Result.add(0);
        int StartCounter = 1;
        int EndCounter = 0;

        for (StartCounter = 1; StartCounter < Start.length; StartCounter++){
            if(Start[StartCounter]>=End[EndCounter]){
                Result.add(StartCounter);
                EndCounter = StartCounter;
            }
        }
        return Result;
    }
}
