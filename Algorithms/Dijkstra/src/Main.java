public class Main {
    public static void main(String[] args) {

        String [] names = new String[]{"A","B","C","D","E","F","G","H","I","J"};
        Graph ob = new Graph(names);

        ob.AddEdges(0,new int[]{1,2,3}, new double[] {2,4,3});
        ob.AddEdges(1,new int[]{4,5,6}, new double[] {7,4,6});
        ob.AddEdges(2,new int[]{4,5,6}, new double[] {3,2,4});
        ob.AddEdges(3,new int[]{4,5,6}, new double[] {4,1,5});
        ob.AddEdges(4,new int[]{7,8}, new double[] {1,4});
        ob.AddEdges(5,new int[]{7,8}, new double[] {6,3});
        ob.AddEdges(6,new int[]{7,8}, new double[] {3,3});
        ob.AddEdges(7,new int[]{9}, new double[] {3});
        ob.AddEdges(8,new int[]{9}, new double[] {4});

        ob.Dijkstra();

    }
}