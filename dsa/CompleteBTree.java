public class CompleteBTree<Type> {
    protected BinaryTreeNode<Type> root;
    private Queue<BinaryTreeNode<Type>> insertionQueue;

    public CompleteBTree() {
        root = null;
        insertionQueue = new Queue<>();
    }

    public void insert(Type data) {
        BinaryTreeNode<Type> bnode = new BinaryTreeNode<>(data);
        if (root == null) {
            root = bnode;
        } else {
            BinaryTreeNode<Type> parent = insertionQueue.front().value;
            if (parent.leftChild == null) {
                parent.leftChild = bnode;
            } else if (parent.rightChild == null) {
                parent.rightChild = bnode;
            } else {
                insertionQueue.pop();
                parent = insertionQueue.front().value;
                parent.leftChild = bnode;
            }
        }
        insertionQueue.push(bnode);
    }


    public void preorder(BinaryTreeNode<Type> node) {
        if (node == null)
            return;
        System.out.println(node);
        preorder(node.leftChild);
        preorder(node.rightChild);
    }
}