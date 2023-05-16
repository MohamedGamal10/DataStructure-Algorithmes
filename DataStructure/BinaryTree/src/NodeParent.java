public class NodeParent
{
    public TreeNode Node;
    public TreeNode Parent;
    public Boolean isLeft;

    public NodeParent(TreeNode _Node, TreeNode _Parent, Boolean _isLeft)
    {
        this.Node = _Node;
        this.Parent = _Parent;
        this.isLeft = _isLeft;
    }
}
