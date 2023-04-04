import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private int last_index = 0;
    public Vertex [] vertices;

    public Graph (String [] names){
        vertices = new Vertex[names.length];
        for (String name:names) {
            this.vertices[last_index] = new Vertex();
            this.vertices[last_index].Name = name;
            last_index++;
        }
    }

    public void AddEdges(int vertexIndex, int[] targets){
        this.vertices[vertexIndex].VertexLinks = new Edge[targets.length];
        for (int i = 0; i < targets.length; i++) {
            this.vertices[vertexIndex].VertexLinks[i] = new Edge(this.vertices[vertexIndex], this.vertices[targets[i]]);
        }
    }

    public void BFS (){
        System.out.println("BFS From Graph Class");
        int v = vertices.length;
        Queue<Vertex> q = new LinkedList<>();
        q.add(this.vertices[0]);
        this.vertices[0].Visited = true;

        Vertex current_vertex ;
        Edge[] destinations;

        while (q.size() > 0){
            current_vertex = q.poll ();
            destinations = current_vertex.VertexLinks;
            for (int i = 0; i < destinations.length; i++) {
                if(destinations[i].Target.Visited == false){
                    q.add(destinations[i].Target);
                    destinations[i].Target.Visited =true;
                    System.out.println(current_vertex.Name + " - " + destinations[i].Target.Name);
                }
            }
        }
        RestoreVertices();
    }
    public void RestoreVertices(){
        for (Vertex v:this.vertices) {
            v.Visited = false;
        }
    }
}
