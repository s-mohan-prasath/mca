public class BinaryTree<Type> {
    BinaryTreeNode<Type> root;

    public BinaryTree() {
        this.root = null;
    }

    public void preorder(BinaryTreeNode<Type> node) {
        if (node == null)
            return;
        System.out.println(node);
        preorder(node.leftChild);
        preorder(node.rightChild);
    }

    public void postorder(BinaryTreeNode<Type> node) {
        if (node == null)
            return;
        postorder(node.leftChild);
        postorder(node.rightChild);
        System.out.println(node);
    }

    public void inorder(BinaryTreeNode<Type> node) {
        if (node == null)
            return;
        inorder(node.leftChild);
        System.out.println(node);
        inorder(node.rightChild);
    }
}
