public class BinarySearchTree<Type extends Comparable<Type>> {
    BinaryTreeNode<Type> root;
    int length;

    public BinarySearchTree() {
        this.root = null;
        this.length = 0;
    }

    public void insert(Type data) {
        BinaryTreeNode<Type> node = new BinaryTreeNode<>(data);
        if (this.length == 0) {
            root = node;
        } else {
            BinaryTreeNode<Type> tmp = root;
            while (true) {
                if (data.compareTo(tmp.data) >= 0) {
                    if (tmp.rightChild == null) {
                        tmp.rightChild = node;
                        break;
                    }
                    tmp = tmp.rightChild;
                } else {
                    if (tmp.leftChild == null) {
                        tmp.leftChild = node;
                        break;
                    }
                    tmp = tmp.leftChild;
                }
            }
        }
        this.length++;
    }

    public void insertListOfNodes(Type[] list) {
        int len = list.length;
        for (int i = 0; i < len; i++) {
            this.insert(list[i]);
        }
    }

    public BinaryTreeNode<Type> search(Type data) {
        if (this.length == 0)
            return null;
        BinaryTreeNode<Type> tmp = this.root;
        while (tmp != null) {
            if (tmp.data.compareTo(data) == 0)
                return tmp;
            else if (tmp.data.compareTo(data) < 0)
                tmp = tmp.rightChild;
            else
                tmp = tmp.leftChild;
        }
        return null;
    }

    public BinaryTreeNode<Type> delete(Type key) {
        BinaryTreeNode<Type> tmp, node, deletedNode = null;
        if (this.length == 0) {
            deletedNode = null;
        } else if (this.root.data == key) {
            deletedNode = this.root;
            this.root = delete_helper(this.root);
        } else {
            tmp = this.root;
            while (tmp != null) {
                if (tmp.data.compareTo(key) < 0) {
                    if (tmp.rightChild != null && tmp.rightChild.data.compareTo(key) == 0) {
                        deletedNode = tmp.rightChild;
                        node = delete_helper(tmp.rightChild);
                        tmp.rightChild = node;
                        break;
                    }
                    tmp = tmp.rightChild;
                } else {
                    if (tmp.leftChild != null && tmp.leftChild.data.compareTo(key) == 0) {
                        deletedNode = tmp.leftChild;
                        node = delete_helper(tmp.leftChild);
                        tmp.leftChild = node;
                        break;
                    }
                    tmp = tmp.leftChild;
                }
            }
        }
        return deletedNode;
    }

    public BinaryTreeNode<Type> getRightMostChild(BinaryTreeNode<Type> node) {
        if (node == null)
            return node;
        while (node.rightChild != null)
            node = node.rightChild;
        return node;
    }

    public BinaryTreeNode<Type> getLeftMostChild(BinaryTreeNode<Type> node) {
        if (node == null)
            return node;
        while (node.leftChild != null)
            node = node.leftChild;
        return node;
    }

    private BinaryTreeNode<Type> delete_helper(BinaryTreeNode<Type> node) {
        if (node.leftChild == null)
            return node.rightChild;
        else if (node.rightChild == null)
            return node.leftChild;
        else {
            BinaryTreeNode<Type> leftChildsRightMostNode;
            leftChildsRightMostNode = getRightMostChild(node.leftChild);
            leftChildsRightMostNode.rightChild = node.rightChild;
            return node.leftChild;
        }
    }

    public void preorder(BinaryTreeNode<Type> node) {
        if (node == null)
            return;
        System.out.print(node + " ");
        preorder(node.leftChild);
        preorder(node.rightChild);
    }

    public void postorder(BinaryTreeNode<Type> node) {
        if (node == null)
            return;
        postorder(node.leftChild);
        postorder(node.rightChild);
        System.out.print(node + " ");
    }

    public void inorder(BinaryTreeNode<Type> node) {
        if (node == null)
            return;
        inorder(node.leftChild);
        System.out.print(node + " ");
        inorder(node.rightChild);
    }
}