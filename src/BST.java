import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Olivia Cheng
 * @version: 12/10/25
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        // TODO: Complete the search function
        return binarySearch(val, root);
    }

    public boolean binarySearch(int val, BSTNode currRoot) {
        // If we have traversed outside our tree, beyond a leaf, it will not exist; hence, false
        if (currRoot == null) {
            return false;
        }

        // If the currRoot is equal to value, it is found
        if (currRoot.getVal() == val)
        {
            return true;
        }

        // If the value is smaller, move down towards the left
        if (currRoot.getVal() > val) {
`           return binarySearch(val, currRoot.getLeft());
        }
        else
        {
            return binarySearch(val, currRoot.getRight());
        }
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        ArrayList<BSTNode> nodes = new ArrayList<>();
        doInOrder(root, nodes);

        return nodes;
    }

    public void doInOrder(BSTNode currRoot, ArrayList<BSTNode> nodes)
    {
        // Check if the node exists, if not move back up the tree to the leaf
        if (currRoot == null)
        {
            return;
        }

        // Traverse down the left side of the tree
        doInOrder(currRoot.getLeft(), nodes);

        // Add the root to array
        nodes.add(currRoot);

        // Traverse down the right side of the tree
        doInOrder(currRoot.getRight(), nodes);
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        ArrayList<BSTNode> nodes = new ArrayList<>();
        doPreorder(root, nodes);

        return nodes;
    }

    public void doPreorder(BSTNode currRoot, ArrayList<BSTNode> nodes) {
        // Check if the node exists, if not move back up the tree to the leaf
        if (currRoot == null)
        {
            return;
        }

        // Adds the current root
        nodes.add(currRoot);

        // Traverse down the left side of the tree
        doPreorder(currRoot.getLeft(), nodes);

        // Traverse down the right side of the tree
        doPreorder(currRoot.getRight(), nodes);
    }


    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        ArrayList<BSTNode> nodes = new ArrayList<>();
        doPostorder(root, nodes);

        return nodes;
    }

    public void doPostorder(BSTNode currRoot, ArrayList<BSTNode> nodes) {
        // Check if the node exists, if not move back up the tree to the leaf
        if (currRoot == null)
        {
            return;
        }

        // Traverse down the left side of the tree
        doPostorder(currRoot.getLeft(), nodes);

        // Traverse down the right side of the tree
        doPostorder(currRoot.getRight(), nodes);

        // Adds the current root
        nodes.add(currRoot);
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        if ()
    }

    public void addInsert(int val, BSTNode currRoot)
    {
        // Check if the node exists, if not move back up the tree to the leaf
        if (currRoot == null)
        {
            return;
        }

        if (currRoot.getVal() > val)
        {
            addInsert(val, currRoot.getLeft());
        }
        else
        {
            addInsert(val, currRoot.getRight());
        }
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
