//Heap Node class which have the data
public class HeapNode {
    public char data;
    public int freq;
    public HeapNode left;
    public HeapNode right;

    //Constructor
    public HeapNode (char data, int freq){
        this.data = data;
        this.freq = freq;
        this.left = this.right = null;
    }
}
