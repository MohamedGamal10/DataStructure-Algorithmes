import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTree <Tdata extends Comparable<Tdata>>
{
    private TreeNode Root;

    public void Insert (Tdata _data)
    {
        TreeNode newNode = new TreeNode(_data);
        if (this.Root == null)
        {
            this.Root = newNode;
            return;
        }

        Queue<TreeNode> q = new Queue<TreeNode>();
        q.enqueue(this.Root);

        while (!q.isEmpty())
        {
            TreeNode currentNode = q.dequeue();
            if (currentNode.Left == null)
            {
                currentNode.Left = newNode;
                break;
            }
            else
            {
                q.enqueue(currentNode.Left);
            }

            if (currentNode.Right == null)
            {
                currentNode.Right = newNode;
                break;
            }
            else
            {
                q.enqueue(currentNode.Right);
            }
        }

    }

    public int Height ()
    {
        return internalHeight(this.Root);
    }
    private int internalHeight(TreeNode node)
    {
        if (node == null) return 0;
        return 1 + Math.max(internalHeight(node.Left), internalHeight(node.Right));
    }

    public void PreOrder()
    {
        internalPreOrder(this.Root);
        System.out.println("");
    }
    private void internalPreOrder(TreeNode node)
    {
        if (node == null) return;
        System.out.print(node.Data + " -> ");
        internalPreOrder(node.Left);
        internalPreOrder(node.Right);
    }

    public void InOrder()
    {
        internalInOrder(this.Root);
        System.out.println("");
    }
    private void internalInOrder(TreeNode node)
    {
        if (node == null) return;
        internalInOrder(node.Left);
        System.out.print(node.Data + " -> ");
        internalInOrder(node.Right);
    }

    public void PostOrder()
    {
        internalPostOrder(this.Root);
        System.out.println("");
    }
    private void internalPostOrder(TreeNode node)
    {
        if (node == null) return;
        internalInOrder(node.Left);
        internalInOrder(node.Right);
        System.out.print(node.Data + " -> ");
    }
    public void printBinaryTree()
    {
        int treeHeight = getHeight(this.Root);

        // Create a placeholder matrix for tree printing
        String[][] treeMatrix = new String[treeHeight][(int) Math.pow(2, treeHeight) - 1];
        for (String[] row : treeMatrix) {
            Arrays.fill(row, " ");
        }

        // Populate the matrix with tree nodes
        populateMatrix(this.Root, treeMatrix, 0, 0, treeMatrix[0].length);

        // Print the matrix
        for (String[] row : treeMatrix) {
            for (String cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(node.Left), getHeight(node.Right));
    }

    private void populateMatrix(TreeNode node, String[][] treeMatrix, int row, int left, int right) {
        if (node == null) {
            return;
        }

        // Calculate the column index for the current node
        int mid = (left + right) / 2;
        treeMatrix[row][mid] = String.valueOf(node.Data);

        // Recursively populate the matrix for the left and right subtrees
        populateMatrix(node.Left, treeMatrix, row + 1, left, mid - 1);
        populateMatrix(node.Right, treeMatrix, row + 1, mid + 1, right);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////
    /*                              Binary Search tree Implementation                             */
    ///////////////////////////////////////////////////////////////////////////////////////////////

    public void BSInsert(Tdata _data)
    {
        TreeNode newNode = new TreeNode(_data);
        if (this.Root == null)
        {
            this.Root = newNode;
            return;
        }

        TreeNode currentNode = this.Root;

        while (currentNode != null)
        {
            if(currentNode.Data.compareTo(_data) > 0 )
            {
                if (currentNode.Left == null)
                {
                    currentNode.Left = newNode;
                    break;
                }
                else
                {
                    currentNode = currentNode.Left;
                }
            }
            else
            {
                if (currentNode.Right == null)
                {
                    currentNode.Right = newNode;
                    break;
                }
                else
                {
                    currentNode = currentNode.Right;
                }
            }
        }
    }

    private TreeNode BSFind (Tdata _data)
    {
        TreeNode currentNode = this.Root;

        while (currentNode != null)
        {

            if (currentNode.Data.compareTo(_data) == 0)
            {
                return currentNode;
            }
            else if (currentNode.Data.compareTo(_data) > 0)
            {
                currentNode = currentNode.Left;
            }
            else
            {
                currentNode = currentNode.Right;
            }

        }
        return null;
    }

    public boolean IsExist (Tdata _data)
    {
        return BSFind(_data) != null;
    }

    NodeParent FindNodeParent (Tdata _data)
    {
        TreeNode currentNode = this.Root;
        TreeNode Parent = null;
        NodeParent nodeParentInfo = null;
        boolean left = false;

        while (currentNode != null)
        {

            if (currentNode.Data.compareTo(_data) == 0)
            {
                nodeParentInfo  = new NodeParent(currentNode,Parent,left);
                break;
            }
            else if (currentNode.Data.compareTo(_data) > 0)
            {
                Parent = currentNode;
                left = true;
                currentNode = currentNode.Left;
            }
            else
            {
                Parent = currentNode;
                left = false;
                currentNode = currentNode.Right;
            }
        }
        return nodeParentInfo;

    }

    public void BSDelete (Tdata _data)
    {
        NodeParent nodeParentInfo = this.FindNodeParent(_data);

        if(nodeParentInfo.Node ==null) return;

        if(nodeParentInfo.Node.Left != null && nodeParentInfo.Node.Right != null)
        {
            BSDelete_Has_Childs(nodeParentInfo.Node);
        }
        else if (nodeParentInfo.Node.Left != null ^ nodeParentInfo.Node.Right != null)
        {
            BSDelete_Has_One_Child(nodeParentInfo.Node);
        }
        else
        {
            BSDelete_Leaf(nodeParentInfo);
        }
    }

    private void BSDelete_Has_Childs (TreeNode nodeToDelete)
    {
        TreeNode currentNode = nodeToDelete.Right;
        TreeNode parent = null;

        while (currentNode.Left != null)
        {
            parent = currentNode;
            currentNode = currentNode.Left;
        }

        if(parent != null)
        {
            parent.Left = currentNode.Right;
        }
        else
        {
            nodeToDelete.Right = currentNode.Right;
        }
        nodeToDelete.Data = currentNode.Data;
    }

    private void BSDelete_Has_One_Child (TreeNode nodeToDelete)
    {
        TreeNode nodeToReplace = null;

        if(nodeToDelete.Left != null)
        {
            nodeToReplace = nodeToDelete.Left;
        }
        else
        {
            nodeToReplace = nodeToDelete.Right;
        }
        nodeToDelete.Data = nodeToReplace.Data;
        nodeToDelete.Left = nodeToReplace.Left;
        nodeToDelete.Right = nodeToReplace.Right;
    }

    private void BSDelete_Leaf (NodeParent nodeParentInfo)
    {
        if(nodeParentInfo.Parent == null)
        {
            this.Root = null;
        }
        else
        {
            if(nodeParentInfo.isLeft)
            {
                nodeParentInfo.Parent.Left = null;
            }
            else
            {
                nodeParentInfo.Parent.Right = null;
            }
        }
    }

    public void Balance()
    {
        ArrayList<Tdata> nodes = new ArrayList<Tdata>();
        InOrderToArray(this.Root, nodes);
        this.Root = RecursiveBalance(0,nodes.size() - 1,nodes);
    }

    void InOrderToArray(TreeNode node , ArrayList<Tdata> nodes)
    {
        if (node == null) return;
        InOrderToArray(node.Left, nodes);
        nodes.add((Tdata) node.Data);
        InOrderToArray(node.Right, nodes);
    }

    TreeNode RecursiveBalance (int start, int end, ArrayList<Tdata> nodes)
    {
        if (start > end) return null;
        int mid = (start + end)/2;
        TreeNode newNode = new TreeNode(nodes.get(mid));
        newNode.Left = RecursiveBalance(start, mid -1, nodes);
        newNode.Right = RecursiveBalance(mid + 1, end, nodes);


        return newNode;
    }
}
