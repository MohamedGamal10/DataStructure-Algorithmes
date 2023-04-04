import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

        //Define Inputs
        int v = 9;
        Hashtable graph = new Hashtable<>(v);
        graph.put('A', new char[]{'B', 'C'});
        graph.put('B', new char[] {'E', 'D', 'A'});
        graph.put('C', new char[] {'D', 'F', 'A'});
        graph.put('D', new char[] {'E', 'F', 'B'});
        graph.put('E', new char[] {'F', 'B'});
        graph.put('F', new char[] {'D', 'E', 'C', 'H'});
        graph.put('G', new char[] {'H', 'I'});
        graph.put('H', new char[] {'G', 'I', 'F'});
        graph.put('I', new char[] {'G', 'H'});

        //Define Queue and add the first item
        Queue<Character> q = new LinkedList<>();
        q.add('A');

        //Define Visited
        Hashtable visited = new Hashtable<>(v);
        visited.put('A', true);

        // Current and Destinations vertices
        char current_vertex;
        char [] destinations;


        //Calculations
        while (q.size() > 0){
            current_vertex = q.poll ();
            destinations = (char[]) graph.get(current_vertex);
            for (int i = 0; i < destinations.length; i++) {
                if(visited.containsKey(destinations[i])== false){
                    q.add(destinations[i]);
                    visited.put(destinations[i] , true);
                    System.out.println(current_vertex + " - " + destinations[i]);
                }
                
            }

        }












    }
}