public class TreeNode <Tdata extends Comparable<Tdata>>
{
    public Tdata Data;
    public TreeNode Left;
    public TreeNode Right;

    public TreeNode(Tdata _data)
    {
        this.Data = _data;
    }

    public int compare(Tdata obj1, Tdata obj2) {
        return obj1.compareTo(obj2);
    }
}
