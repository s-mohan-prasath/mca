public class BinaryTreeNode<Type> {
    Type data;
    BinaryTreeNode<Type> leftChild;
    BinaryTreeNode<Type> rightChild;

    public BinaryTreeNode(Type data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }

    @Override
    public String toString() {
        return "" + this.data;
    }
}
