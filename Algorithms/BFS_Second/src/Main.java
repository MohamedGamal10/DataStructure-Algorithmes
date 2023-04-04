import java.util.Hashtable;

public class Main {
    public static void main(String[] args) {

        String [] names = new String[]{"A","B","C","D","E","F","G","H","I"};
        //String [] names = new String[]{"0","1","2","3","4","5","6","7","8"};
        Graph ob = new Graph(names);

        //Graph.Add('A', new char[]{'B', 'C'});
        ob.AddEdges(0,new int[]{1,2});

        //graph.put('B', new char[] {'E', 'D', 'A'});
        ob.AddEdges(1,new int[]{4,3,0});

        //graph.put('C', new char[] {'D', 'F', 'A'});
        ob.AddEdges(2,new int[]{3,5,0});

        //graph.put('D', new char[] {'E', 'F', 'B'});
        ob.AddEdges(3,new int[]{4,5,1});

        //graph.put('E', new char[] {'F', 'B'});
        ob.AddEdges(4,new int[]{5,1});

        //graph.put('F', new char[] {'D', 'E', 'C', 'H'});
        ob.AddEdges(5,new int[]{3,4,2,7});

        //graph.put('G', new char[] {'H', 'I'});
        ob.AddEdges(6,new int[]{7,8});

        //graph.put('H', new char[] {'G', 'I', 'F'});
        ob.AddEdges(7,new int[]{6,8,5});

        //graph.put('I', new char[] {'G', 'H'});
        ob.AddEdges(8,new int[]{6,7});

        ob.BFS();

    }
}