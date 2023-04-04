public class Main {
    public static void main(String[] args) {

        String [] names = new String[]{"A","B","C","D","E","F","G","H","I"};
        Graph ob = new Graph(names);

        ob.AddEdges(0,new int[]{1,2});
        ob.AddEdges(1,new int[]{0,3,4});
        ob.AddEdges(2,new int[]{0,3,5});
        ob.AddEdges(3,new int[]{1,2,4});
        ob.AddEdges(4,new int[]{1,5});
        ob.AddEdges(5,new int[]{2,3,4,7});
        ob.AddEdges(6,new int[]{7,8});
        ob.AddEdges(7,new int[]{5,6,8});
        ob.AddEdges(8,new int[]{6,7});

        ob.DFS();

    }
}