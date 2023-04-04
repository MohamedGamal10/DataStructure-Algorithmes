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


    public void AddEdges(int vertexIndex, int[] targets, double [] weights){
        this.vertices[vertexIndex].VertexLinks = new Edge[targets.length];
        for (int i = 0; i < targets.length; i++) {
            this.vertices[vertexIndex].VertexLinks[i] = new Edge(this.vertices[vertexIndex], this.vertices[targets[i]], weights[i]);
        }
    }

    public void RestoreVertices(){
        for (Vertex v:this.vertices) {
            v.Visited = false;
            v.TotalLength = 0;
            v.SourceOfTotalLength = null;
        }
    }

    public void Dijkstra (){

        for (int i = 1; i < this.vertices.length; i++) {
            this.vertices[i].TotalLength = Double.MAX_VALUE;
        }

        Vertex current_vertex;
        for (int i = 0; i < this.vertices.length; i++) {
            current_vertex = this.vertices[i];
            Edge[] destinations = current_vertex.VertexLinks;

            if(destinations == null) continue;

            Edge current_edge;
            for (int j = 0; j < destinations.length; j++) {
                current_edge = destinations[j];
                double new_length = current_vertex.TotalLength + current_edge.Weight;

                if (new_length < current_edge.Target.TotalLength){
                    current_edge.Target.TotalLength = new_length;
                    current_edge.Target.SourceOfTotalLength = current_vertex;
                }
            }
        }

        ///Print Solution
        String Path = this.vertices[this.vertices.length - 1].Name;
        Vertex v = this.vertices[this.vertices.length -1];

        while (v.SourceOfTotalLength != null){
            Path = v.SourceOfTotalLength.Name + " - " + Path;
            v= v.SourceOfTotalLength;
        }

        System.out.println("Total Length : " + this.vertices[this.vertices.length - 1].TotalLength);
        System.out.println("Path : " + Path);

        this.RestoreVertices();


    }

}
