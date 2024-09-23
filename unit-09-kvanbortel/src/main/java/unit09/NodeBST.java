/* This program lets you insert values and search through the tree
 * Author: Kayla Van Bortel */

package unit09;

public class NodeBST<E extends Comparable<E>> implements BinarySearchTree<E> {
    private BinaryNode<E> root;
    private int size;

    public NodeBST() {
        root = null;
        size = 0;
    }

    private void binaryInsert(BinaryNode<E> node, E value) {
        if ((value).compareTo(node.getValue()) < 0) { // <
            if (node.getLeft() == null) {
                node.setLeft(new BinaryNode<>(value));
            }
            else {
                binaryInsert(node.getLeft(), value);
            }
        }
        else if (value.compareTo(node.getValue()) > 0) { // >
            if (node.getRight() == null) {
                node.setRight(new BinaryNode<>(value));
            }
            else {
                binaryInsert(node.getRight(), value);
            }
        }
    }

    @Override
    public void insert(E value) {
        if (root == null) {
            root = new BinaryNode<>(value);
        }
        else {
            binaryInsert(root, value);
        }
        size++;
    }

    @Override
    public boolean search(E target) {
        if (root == null) {
            return false;
        }
        return binarySearch(root, target);
    }

    private boolean binarySearch(BinaryNode<E> node, E target) {
        if (target.equals(node.getValue())) {
            return true;
        }
        else if (target.compareTo(node.getValue()) < 0 ) { // <
            if (node.getLeft() == null) {
                return false;
            }
            else {
                return binarySearch(node.getLeft(), target);
            }
        }
        else {
            if(node.getRight() == null) {
                return false;
            }
            else {
                return binarySearch(node.getRight(), target);
            }
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (root == null) {
            return "<empty>";
        }
        else {
            return root.infixTraversal();
        }
    }

    public static void main(String[] args) {
        BinarySearchTree<String> nodeBST = new NodeBST<>();
        System.out.println(nodeBST);

        nodeBST.insert("5");
        nodeBST.insert("7");
        nodeBST.insert("6");
        nodeBST.insert("2");
        nodeBST.insert("9");
        nodeBST.insert("1");
        nodeBST.insert("3");
        System.out.println(nodeBST);

        System.out.println(nodeBST.search("6"));
        System.out.println(nodeBST.search("10"));
    }
}
