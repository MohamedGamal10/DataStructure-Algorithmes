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


    public void RestoreVertices(){
        for (Vertex v:this.vertices) {
            v.Visited = false;
        }
    }

    public void DFS(){
        System.out.println("DFS From Graph Class");
        DFSRecursion(this.vertices[0]);
        RestoreVertices();
    }

    private void DFSRecursion(Vertex current_vertex){
        current_vertex.Visited = true;
        Edge[] destinations = current_vertex.VertexLinks;
        for (int i = 0; i < destinations.length; i++) {
            if(destinations[i].Target.Visited == false){
                System.out.println(current_vertex.Name + " - " + destinations[i].Target.Name);
                DFSRecursion(destinations[i].Target);
            }
            
        }


    }
}
