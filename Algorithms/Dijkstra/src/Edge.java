public class Edge {
    public double Weight;
    public Vertex Source;
    public Vertex Target;

    public Edge (Vertex source, Vertex target, double weight){
        this.Source = source;
        this.Target = target;
        this.Weight = weight;

    }
}
