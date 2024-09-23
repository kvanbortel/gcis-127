/* This program handles inserting and serching Binary Nodes in a tree
 * Author: Kayla Van Bortel */

package unit09;

public class BinaryNode<E> {
    private E value;
    private BinaryNode<E> left;
    private BinaryNode<E> right;

    public BinaryNode(E value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public BinaryNode<E> getLeft() {
        return left;
    }

    public void setLeft(BinaryNode<E> left) {
        this.left = left;
    }

    public BinaryNode<E> getRight() {
        return right;
    }

    public void setRight(BinaryNode<E> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "BinaryNode{value=" + value + ", left=" + left + ", right=" + right + "}";
    }

    public String infixTraversal() {
        String tree = "";
        if (left != null) {
            tree += left.infixTraversal();
        }
        tree += value + " ";
        if (right != null) {
            tree += right.infixTraversal();
        }
        return tree;
    }

    public boolean search(E target) {
        if (value == target) {
            return true;
        }
        else if (left != null && left.search(target)) {
            return true;
        }
        else if (right != null && right.search(target)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        BinaryNode<String> two = new BinaryNode<>("2");
        BinaryNode<String> three = new BinaryNode<>("3");
        two.setLeft(three);
        BinaryNode<String> seven = new BinaryNode<>("7");
        two.setRight(seven);
        BinaryNode<String> nine = new BinaryNode<>("nine");
        three.setLeft(nine);
        BinaryNode<String> four = new BinaryNode<>("4");
        three.setRight(four);
        BinaryNode<String> one = new BinaryNode<>("one");
        seven.setLeft(one);
        BinaryNode<String> six = new BinaryNode<>("6");
        seven.setRight(six);
        System.out.println(two);

        System.out.println(two.infixTraversal());

        System.out.println(two.search("one"));
        System.out.println(two.search("8"));
        System.out.println(two.search("2"));

    }


}
