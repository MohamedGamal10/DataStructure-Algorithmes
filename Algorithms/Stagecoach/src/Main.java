import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //inputs
        char [] label = {'A','B','C','D','E','F','G','H','I','J'};
        int [] [] data = {{0,2,4,3,0,0,0,0,0,0},
                          {0,0,0,0,7,4,6,0,0,0},
                          {0,0,0,0,3,2,4,0,0,0},
                          {0,0,0,0,4,1,5,0,0,0},
                          {0,0,0,0,0,0,0,1,4,0},
                          {0,0,0,0,0,0,0,6,3,0},
                          {0,0,0,0,0,0,0,3,3,0},
                          {0,0,0,0,0,0,0,0,0,3},
                          {0,0,0,0,0,0,0,0,0,4},
                          {0,0,0,0,0,0,0,0,0,0}};

        //Calculate Minimum Cost
        int n = data.length;
        State [] States = new State[n];
        States[n-1]= new State(' ',' ',0);

        for (int i = n-2; i >=0 ; i--) {
            States[i] = new State(label[i],label[i],Integer.MAX_VALUE);
            for (int j = i+1; j <n ; j++) {
                if (data[i][j]==0) continue;

                int newcost = data[i][j]+States[j].Cost;

                if(newcost < States[i].Cost){
                    States[i].To = label[j];
                    States[i].Cost = newcost;
                }
            }


        }

        //Print States
        for (int k = 0; k < States.length ; k++) {
            System.out.print("[ From :" +States[k].From + ',');
            System.out.print(' ');
            System.out.print(" To : " + States[k].To+',');
            System.out.print(' ');
            System.out.println(" Cost : " +States[k].Cost + " ]");
        }

        //Print Minimum Cost
        System.out.println("Minimum Cost : "+States[0].Cost);


        //Get Minimum Path
        ArrayList<Character> Path = new ArrayList<Character>();
        Path.add(0,'A');
        int i = 0;
        int j = 0;

        while(i < States.length){
            if(States[i].From == Path.get(j)){
                Path.add(j+1,States[i].To);
                j++;
            }
            i++;

        }

        System.out.println("Minimum Path : "+Path);


    }
}