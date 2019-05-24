package tree;

public class TestTreeImplementation {
    public static void main(String[] args) {

       LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();

       Position<Integer> root = tree.addRoot(5);
       Position<Integer> leftChild1 = tree.addLeft(root,3);
       Position<Integer> rightChild1 = tree.addRight(root, 6);

       tree.addLeft(leftChild1, 2);
       tree.addRight(leftChild1, 4);

       tree.positionsPreorder().forEach(node -> {
           System.out.println(node.getElement());
       });

       tree.positionsPostorder().forEach(node -> {
           System.out.println(node.getElement());
       });

       tree.positionsPostorder().forEach(node -> {
           System.out.println(node.getElement());
       });

    }
}
